package br.com.magnasistemas.petrocityapi.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.magnasistemas.petrocityapi.model.Realtor;

public class RealtorForm {

	@NotNull
	@NotEmpty
	private String name;

	@NotNull
	@NotEmpty
	private String email;

	@NotNull
	@NotEmpty
	private String creci;

	@NotNull
	@NotEmpty
	private String phoneNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreci() {
		return creci;
	}

	public void setCreci(String creci) {
		this.creci = creci;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Método responsável pela conversão de RealtorForm para Realtor
	 * 
	 * @param
	 * 
	 * @return Objeto convertido.
	 */
	public Realtor converter() {
		return new Realtor(name, email, creci, phoneNumber);
	}

	/**
	 * Método responsável pela atualização do cadastro do corretor
	 * 
	 * @param realtor
	 * 
	 * @return Corretor populado conforme formulario
	 */
	public Realtor update(Realtor realtor) {
		realtor.setName(this.name);
		realtor.setEmail(this.email);
		realtor.setCreci(this.creci);
		realtor.setPhoneNumber(this.phoneNumber);

		return realtor;
	}
}
