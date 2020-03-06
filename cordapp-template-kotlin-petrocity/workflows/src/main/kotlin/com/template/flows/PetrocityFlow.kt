package com.template.flows

import co.paralleluniverse.fibers.Suspendable
import com.template.contracts.PetrocityContract
import com.template.states.PetrocityState
import net.corda.core.contracts.Command
import net.corda.core.contracts.UniqueIdentifier
import net.corda.core.contracts.requireThat
import net.corda.core.flows.*
import net.corda.core.identity.Party
import net.corda.core.node.ServiceHub
import net.corda.core.transactions.SignedTransaction
import net.corda.core.transactions.TransactionBuilder

@InitiatingFlow
@StartableByRPC
class PetrocityIssueInitiator(
        val banco: Party,
        val interessado: Party,
        val cliente: String,
        val valor: Int,
        val empreendimento: String,
        val local: String
) : FlowLogic<SignedTransaction>() {
    @Suspendable
    override fun call(): SignedTransaction {

        val notary = serviceHub.networkMapCache.notaryIdentities.first()
        val command = Command(PetrocityContract.Commands.Issue(), listOf(banco, interessado).map { it.owningKey })
        val PetrocityState = PetrocityState(
                banco,
                interessado,
                cliente,
                valor,
                empreendimento,
                local,
                UniqueIdentifier()
        )

        val txBuilder = TransactionBuilder(notary)
                .addOutputState(PetrocityState, PetrocityContract.ID)
                .addCommand(command)

        txBuilder.verify(serviceHub)
        val tx = serviceHub.signInitialTransaction(txBuilder)

        val sessions = (PetrocityState.participants - ourIdentity).map { initiateFlow(it as Party) }
        val stx = subFlow(CollectSignaturesFlow(tx, sessions))
        return subFlow(FinalityFlow(stx, sessions))
    }
}

@InitiatedBy(PetrocityIssueInitiator::class)
class PetrocityIssueResponder(val counterpartySession: FlowSession) : FlowLogic<SignedTransaction>() {

    @Suspendable
    override fun call(): SignedTransaction {
        val signedTransactionFlow = object : SignTransactionFlow(counterpartySession) {
            override fun checkTransaction(stx: SignedTransaction) = requireThat {
                val output = stx.tx.outputs.single().data
                "The output must be a PetrocityState" using (output is PetrocityState)
            }
        }
        val txWeJustSignedId = subFlow(signedTransactionFlow)
        return subFlow(ReceiveFinalityFlow(counterpartySession, txWeJustSignedId.id))
    }
}