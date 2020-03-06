package br.com.magnasistemas.petrocityapi.controller.dto;

import br.com.magnasistemas.petrocityapi.model.RealState;

public class RealStateDto {

	private String description;

	public String getDescription() {
		return description;
	}
	
	public RealStateDto(RealState realState) {
		this.description = realState.getDescription();
	}

}
