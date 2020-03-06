package br.com.magnasistemas.petrocityapi.rpc;

import net.corda.client.rpc.CordaRPCClient;
import net.corda.client.rpc.CordaRPCConnection;
import net.corda.core.identity.CordaX500Name;
import net.corda.core.identity.Party;
import net.corda.core.messaging.CordaRPCOps;
import net.corda.core.messaging.FlowProgressHandle;
import net.corda.core.node.AppServiceHub;
//import liquibase.logging.LoggerFactory;
import net.corda.core.serialization.SingletonSerializeAsToken;
import net.corda.core.utilities.NetworkHostAndPort;

import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.magnasistemas.petrocityapi.corda.flow.PetrocityFlow;

public class CordaRPC extends SingletonSerializeAsToken {
	
	private final static Logger Logger =  LoggerFactory.getLogger(CordaRPC.class);
	AppServiceHub serviceHub;
	Party partyMember;
	private String banco;
	private String interessado;
	private String cliente;
	private int valor;
	private String empreendimento;
	private String local;
	
	
	public String startRPC(String banco, String interessado, String cliente, String string, int valor, String empreendimento, String local) {
		// TODO Auto-generated method stub
		final NetworkHostAndPort nodeAddress = NetworkHostAndPort.parse("<endereço ip do node Corda>");
		String username = "user1";
		String pwd = "user";
        //String memberName = "";	
		FlowProgressHandle<Void> rpcOpsRetorno;
		this.banco = banco;
		this.interessado = interessado;
		this.cliente = cliente;
		this.valor = valor;
		this.empreendimento = empreendimento;
		this.local = local;
		
		
		final CordaRPCClient client =  new CordaRPCClient(nodeAddress);
		final CreatePartyMember partymember = new CreatePartyMember();
		final CordaRPCConnection connection = client.start(username, pwd);
		final CordaRPCOps cordaRPCOperations = connection.getProxy();
		
		Logger.info(cordaRPCOperations.currentNodeTime().toString());
		
		//CordaX500Name x500name = CordaX500Name.parse("O=Interessado,L=Sao Paulo,C=SP <PARTY CANNONICAL NAME>"); //cria identidade x500 a partir da string canonica da party
		
		//Party otherParty = cordaRPCOperations.wellKnownPartyFromX500Name(partymember.getX500name("<PARTY CANNONICAL NAME>")); //envia a identidade para validação no corda
		
		
		System.out.println(cordaRPCOperations.startTrackedFlowDynamic(PetrocityFlow.class, partymember.partyMember(this.banco, cordaRPCOperations), 
				partymember.partyMember(this.interessado, cordaRPCOperations), this.cliente, this.valor,this.empreendimento , this.local));
		
		rpcOpsRetorno = cordaRPCOperations.startTrackedFlowDynamic(PetrocityFlow.class, partymember.partyMember(this.banco, cordaRPCOperations), 
				partymember.partyMember(this.interessado, cordaRPCOperations), this.cliente, this.valor,this.empreendimento , this.local);
		
		connection.notifyServerAndClose();
		
		return rpcOpsRetorno.getReturnValue().toString();
		
		

	}

}
