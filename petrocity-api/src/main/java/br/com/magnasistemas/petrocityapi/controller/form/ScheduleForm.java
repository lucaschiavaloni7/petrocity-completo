package br.com.magnasistemas.petrocityapi.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ScheduleForm {

	@NotNull
	@NotEmpty
	private String dateOfVisit;

	@NotNull
	@NotEmpty
	private String interestedFederalRegistration;

	@NotNull
	@NotEmpty
	private String realtorCreci;

	public String getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public String getInterestedFederalRegistration() {
		return interestedFederalRegistration;
	}

	public void setInterestedFederalRegistration(String interestedFederalRegistration) {
		this.interestedFederalRegistration = interestedFederalRegistration;
	}

	public String getRealtorCreci() {
		return realtorCreci;
	}

	public void setRealtorCreci(String realtorCreci) {
		this.realtorCreci = realtorCreci;
	}
	
}