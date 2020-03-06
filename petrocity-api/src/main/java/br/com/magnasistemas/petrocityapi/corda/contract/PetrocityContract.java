package br.com.magnasistemas.petrocityapi.corda.contract;

import net.corda.core.contracts.CommandData;
import net.corda.core.contracts.Contract;
import net.corda.core.transactions.LedgerTransaction;

import net.corda.core.contracts.CommandWithParties;
import net.corda.core.identity.Party;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;

import br.com.magnasistemas.petrocityapi.corda.states.*;

import static net.corda.core.contracts.ContractsDSL.requireSingleCommand;

public class PetrocityContract implements Contract {
	
	public static final String ID = "com.template.contracts.PetrocityContract";
	
	public static class Create implements CommandData{
		
	}

	@Override
	public void verify(LedgerTransaction tx) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
		final CommandWithParties<PetrocityContract.Create> command = requireSingleCommand(tx.getCommands(), PetrocityContract.Create.class);
		
		if(!tx.getInputs().isEmpty())
			throw new IllegalArgumentException("no unputs should be consumed qhen issuing");
		if(!(tx.getOutputs().size() == 1))
			throw new IllegalArgumentException("No output state of type Petrocity State");
		
		 final PetrocityState output = tx.outputsOfType(PetrocityState.class).get(0);
	        final Party borrower = output.getBanco();
	        final Party lender = output.getInteressado();
		
		final List<PublicKey> requiredSigners = command.getSigners();
        final List<PublicKey> expectedSigners = Arrays.asList(borrower.getOwningKey(), lender.getOwningKey());

        if (requiredSigners.size() != 2)
            throw new IllegalArgumentException("There must be two signers.");
        if (!(requiredSigners.containsAll(expectedSigners)))
            throw new IllegalArgumentException("The borrower and lender must be signers.");

		
	}
	
	public interface Commands extends CommandData{
		class Action implements Commands{}
	}

}
