package br.com.magnasistemas.petrocityapi.controller.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.magnasistemas.petrocityapi.model.Interested;
import br.com.magnasistemas.petrocityapi.model.Status;

public class InterestedDto {

	private String name;
	private String federalRegistration;
	private String email;
	private Status status;

	public String getName() {
		return name;
	}

	public String getFederalRegistration() {
		return federalRegistration;
	}

	public String getEmail() {
		return email;
	}

	public Status getStatus() {
		return status;
	}

	public InterestedDto(Interested interested) {
		this.name = interested.getName();
		this.federalRegistration = interested.getFederalRegistration();
		this.email = interested.getEmail();
		this.status = interested.getStatus();
	}

	/**
	 * Método responsável pela conversão de Interested para InterestedDto
	 * 
	 * @param List<Interested> interesteds --> Lista com os interessados
	 * 
	 * @return Lista convertida.
	 */
	public static List<InterestedDto> converter(List<Interested> interesteds) {

		List<InterestedDto> interestedsDto = new ArrayList<>();

		for (Interested interested : interesteds) {
			interestedsDto.add(new InterestedDto(interested));
		}

		return interestedsDto;
	}

}
