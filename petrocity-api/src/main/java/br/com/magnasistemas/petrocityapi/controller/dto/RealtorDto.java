package br.com.magnasistemas.petrocityapi.controller.dto;

import br.com.magnasistemas.petrocityapi.model.Realtor;

public class RealtorDto {

	private String name;
	private String email;
	private String creci;
	private String phoneNumber;

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getCreci() {
		return creci;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public RealtorDto(Realtor realtor) {
		this.name = realtor.getName();
		this.email = realtor.getEmail();
		this.creci = realtor.getName();
		this.phoneNumber = realtor.getPhoneNumber();
	}
}
