package br.com.magnasistemas.petrocityapi.config.validation;

public class ErrorFormDto {

	private String field;
	private String message;

	public ErrorFormDto(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public String getMessage() {
		return message;
	}

}
