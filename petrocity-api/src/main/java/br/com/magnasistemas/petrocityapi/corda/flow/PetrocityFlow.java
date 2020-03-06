package br.com.magnasistemas.petrocityapi.corda.flow;

import co.paralleluniverse.fibers.Suspendable;
import net.corda.core.flows.*;
import net.corda.core.utilities.ProgressTracker;
import net.corda.core.contracts.Command;
import net.corda.core.identity.Party;
import net.corda.core.transactions.SignedTransaction;
import net.corda.core.transactions.TransactionBuilder;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;

import br.com.magnasistemas.petrocityapi.corda.contract.*;
import br.com.magnasistemas.petrocityapi.corda.states.*;

public class PetrocityFlow extends FlowLogic<Void> {
	
	private final Party banco; 
	private final Party interessado;
	private final String cliente;
	private final int valor;
	private final String empreendimento;
	private final String localizacao;
	
	
	private final ProgressTracker progressTracker =  new ProgressTracker();
	
	public PetrocityFlow(Party banco, Party interessado, String cliente, int valor, String empreendimento, String localizacao) {
		this.banco = banco;
		this.interessado = interessado;
		this.cliente = cliente;
		this.valor = valor;
		this.empreendimento = empreendimento;
		this.localizacao = localizacao;
	
	}
	
	@Suspendable
	@Override
	public Void call() throws FlowException {
		// TODO Auto-generated method stub
		Party notary = getServiceHub().getNetworkMapCache().getNotaryIdentities().get(0);
		
		PetrocityState outputState = new PetrocityState(banco, interessado, cliente, valor, empreendimento, localizacao);
		//List<PublicKey> requiredSigners = Arrays.asList()
		// ###############################################################
		
		 List<PublicKey> requiredSigners = Arrays.asList(banco.getOwningKey(),interessado.getOwningKey());
	        Command command = new Command<>(new PetrocityContract.Create(), requiredSigners);

	        //crete transaction builder and add components
	        TransactionBuilder txBuilder = new TransactionBuilder(notary)
	                .addOutputState(outputState, PetrocityContract.ID)
	                .addCommand(command);

	        //verify the transaction
	        txBuilder.verify(getServiceHub());

	        //signing the transaction
	        SignedTransaction signedTx = getServiceHub().signInitialTransaction(txBuilder);

	        //create a session with other party
	        FlowSession otherPartySession = initiateFlow(banco);

	        SignedTransaction fullySignedTx = subFlow(new CollectSignaturesFlow(
	                signedTx, Arrays.asList(otherPartySession), CollectSignaturesFlow.tracker()
	        ));

	        //finalize transaction and send it to the counterparty
	        subFlow(new FinalityFlow(fullySignedTx, otherPartySession));

		
		
		// ###############################################################
		
		return null;
	}

	@Override
	public ProgressTracker getProgressTracker() {
		return progressTracker;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Deu certo!!!!!!!!!!!!");
		
	}

}
