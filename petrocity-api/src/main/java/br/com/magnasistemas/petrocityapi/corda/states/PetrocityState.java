package br.com.magnasistemas.petrocityapi.corda.states;

import java.util.List;
import java.util.Arrays;

import br.com.magnasistemas.petrocityapi.corda.contract.*;

import net.corda.core.contracts.*;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;

@BelongsToContract(PetrocityContract.class)
public class PetrocityState implements ContractState {
	
	private Party banco = null;
	private Party interessado = null;
	private String cliente = "";
	private int valor;
	private String empreendimento = "";
	private String localizacao = "";
	

	public PetrocityState(Party banco, Party interessado, String nomeCliente, int valor,
			String empreendimento, String localizacao) {
		// TODO Auto-generated constructor stub
		this.banco = banco;
		this.interessado = interessado;
		this.cliente = nomeCliente;
		this.valor = valor;
		this.empreendimento = empreendimento;
		this.localizacao = localizacao;
		
	}

	@Override
	public List<AbstractParty> getParticipants() {
		// TODO Auto-generated method stub
		return Arrays.asList(interessado,banco);
	}
	
	public Party getBanco() {
		return banco;
	}

	public void setBanco(Party banco) {
		this.banco = banco;
	}
	
	public Party getInteressado() {
		return interessado;
	}

	public void setInteressado(Party interessado) {
		this.interessado = interessado;
	}

	public String getcliente() {
		return cliente;
	}

	public void setcliente(String cliente) {
		this.cliente = cliente;
	}
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public String getEmpreendimento() {
		return empreendimento;
	}

	public void setEmpreendimento(String empreendimento) {
		this.empreendimento = empreendimento;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

}
