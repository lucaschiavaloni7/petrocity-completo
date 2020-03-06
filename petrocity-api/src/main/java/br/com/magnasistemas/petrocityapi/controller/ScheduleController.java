package br.com.magnasistemas.petrocityapi.controller;

import java.net.URI;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.magnasistemas.petrocityapi.controller.dto.ScheduleDto;
import br.com.magnasistemas.petrocityapi.controller.form.ScheduleForm;
import br.com.magnasistemas.petrocityapi.model.Schedule;
import br.com.magnasistemas.petrocityapi.service.ScheduleService;

@RestController
@RequestMapping("/agendaAPI")
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;

	@GetMapping
	@CrossOrigin(origins = "*")
	public List<Schedule> listSchedules() {
		return scheduleService.listSchedules();
	}

	@PostMapping
	@CrossOrigin(origins = "*")
	public ResponseEntity<ScheduleDto> register(@RequestBody @Valid ScheduleForm form, UriComponentsBuilder uriBuilder)
			throws ParseException {
		Schedule schedule = scheduleService.registerSchedule(form);
		URI uri = uriBuilder.path("/agendaAPI").buildAndExpand(schedule.getDateOfVisit()).toUri();
		return ResponseEntity.created(uri).body(new ScheduleDto(schedule));
	}

	@PutMapping("/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<ScheduleDto> update(@PathVariable Long id, @RequestBody @Valid ScheduleForm form)
			throws ParseException {
		boolean updated = scheduleService.updateSchedule(id, form);

		if (updated) {
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Schedule> delete(@PathVariable Long id) {
		boolean delete = scheduleService.deleteSchedule(id);

		if (delete) {
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}
}
