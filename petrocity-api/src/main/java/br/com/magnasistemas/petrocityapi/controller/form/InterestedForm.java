package br.com.magnasistemas.petrocityapi.controller.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.magnasistemas.petrocityapi.model.Interested;
import br.com.magnasistemas.petrocityapi.model.Status;

public class InterestedForm {

	@NotNull
	@NotEmpty
	private String name;

	@NotNull
	@NotEmpty
	@Length(min = 14, max = 18)
	private String federalRegistration;

	@NotNull
	@NotEmpty
	private String phoneNumber;

	@NotNull
	@NotEmpty
	private String email;

	@NotNull
	@NotEmpty
	private String state;

	@NotNull
	@NotEmpty
	private String city;

	private String address;
	private String addressNumber;
	private String complement;
	private String zipCode;
	private Date birth;
	private String maritialStatus;
	private String occupation;
	private Status status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFederalRegistration() {
		return federalRegistration;
	}

	public void setFederalRegistration(String federalRegistration) {
		this.federalRegistration = federalRegistration;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getMaritialStatus() {
		return maritialStatus;
	}

	public void setMaritialStatus(String maritialStatus) {
		this.maritialStatus = maritialStatus;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * Método responsável pela conversão de InterestedForm para Interested
	 * 
	 * 
	 * @return Objeto convertido.
	 */
	public Interested converter() {
		return new Interested(name, federalRegistration, phoneNumber, email, state, city);
	}

	/**
	 * Método responsável pela atualização do cadastro de interessados
	 * 
	 * @param interested 
	 * 
	 * @return Interessado populado conforme formulario
	 */
	public Interested update(Interested interested) {
		interested.setName(this.name);
		interested.setEmail(this.email);
		interested.setFederalRegistration(this.federalRegistration);
		interested.setPhoneNumber(this.phoneNumber);
		interested.setState(this.state);
		interested.setCity(this.city);
		interested.setAddress(this.address);
		interested.setAddressNumber(this.addressNumber);
		interested.setComplement(this.complement);
		interested.setZipCode(this.zipCode);
		interested.setBirth(this.birth);
		interested.setMaritialStatus(this.maritialStatus);
		interested.setOccupation(this.occupation);
		interested.setStatus(this.status);

		return interested;
	}

}
