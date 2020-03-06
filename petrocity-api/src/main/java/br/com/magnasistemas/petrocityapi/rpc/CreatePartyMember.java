package br.com.magnasistemas.petrocityapi.rpc;

import net.corda.core.identity.CordaX500Name;
import net.corda.core.identity.Party;
import net.corda.core.messaging.CordaRPCOps;

public class CreatePartyMember {
	private CordaX500Name x500name;
	
	public Party partyMember(String memberName, CordaRPCOps cordaRPCOperations) {
		
		x500name = CordaX500Name.parse(memberName);
		Party otherParty = cordaRPCOperations.wellKnownPartyFromX500Name(x500name);
		
		return otherParty;
		
	}
	
	

}
