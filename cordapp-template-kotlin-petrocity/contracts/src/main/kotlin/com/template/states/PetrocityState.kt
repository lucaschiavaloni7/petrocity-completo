package com.template.states

import com.template.contracts.PetrocityContract
import com.template.contracts.TemplateContract
import net.corda.core.contracts.BelongsToContract
import net.corda.core.contracts.ContractState
import net.corda.core.contracts.UniqueIdentifier
import net.corda.core.identity.AbstractParty
import net.corda.core.identity.Party

// *********
// * State *
// *********

@BelongsToContract(PetrocityContract::class)
data class PetrocityState(
        val banco: Party,
        val interessado: Party,
        val cliente: String,
        val valor: Int,
        val empreendimento: String,
        val local: String,
        val linearId: UniqueIdentifier
) : ContractState {
    override val participants: List<AbstractParty> = listOf(banco, interessado)
}