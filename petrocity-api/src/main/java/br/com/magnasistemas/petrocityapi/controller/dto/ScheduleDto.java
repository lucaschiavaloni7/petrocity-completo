package br.com.magnasistemas.petrocityapi.controller.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.magnasistemas.petrocityapi.model.Schedule;

public class ScheduleDto {

	private Date dateOfVisit;
	private String nameInterested;
	private String phoneInterested;
	private String nameRealtor;
	private String creciRealtor;

	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	public String getNameInterested() {
		return nameInterested;
	}

	public String getPhoneInterested() {
		return phoneInterested;
	}

	public String getNameRealtor() {
		return nameRealtor;
	}

	public String getCreciRealtor() {
		return creciRealtor;
	}

	public ScheduleDto(Schedule schedule) {
		this.dateOfVisit = schedule.getDateOfVisit();
		this.nameInterested = schedule.getInterested().getName();
		this.phoneInterested = schedule.getInterested().getPhoneNumber();
		this.nameRealtor = schedule.getRealtor().getName();
		this.creciRealtor = schedule.getRealtor().getCreci();
	}

	/**
	 * Método responsável pela conversão de Schedule para ScheduleDto
	 * 
	 * @param List<Schedule> schedules --> Lista com os eventos da agenda
	 * 
	 * @return Lista convertida.
	 */
	public static List<ScheduleDto> converter(List<Schedule> schedules) {

		List<ScheduleDto> schedulesDto = new ArrayList<>();

		for (Schedule schedule : schedules) {
			schedulesDto.add(new ScheduleDto(schedule));
		}

		return schedulesDto;
	}
}
