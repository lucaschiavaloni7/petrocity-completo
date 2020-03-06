package br.com.magnasistemas.petrocityapi.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.petrocityapi.controller.form.ScheduleForm;
import br.com.magnasistemas.petrocityapi.model.Interested;
import br.com.magnasistemas.petrocityapi.model.Realtor;
import br.com.magnasistemas.petrocityapi.model.Schedule;
import br.com.magnasistemas.petrocityapi.repository.InterestedRepository;
import br.com.magnasistemas.petrocityapi.repository.RealtorRepository;
import br.com.magnasistemas.petrocityapi.repository.ScheduleRepository;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository repository;

	@Autowired
	private InterestedRepository interestedRepository;

	@Autowired
	private RealtorRepository realtorRepository;

	public List<Schedule> listSchedules() {
		return repository.findAll();
	}
	
	public Optional<Schedule> findScheduleById(Long id){
		return repository.findById(id);
	}

	@Transactional
	public Schedule registerSchedule(ScheduleForm form) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateFormat = simpleDateFormat.parse(form.getDateOfVisit());

		Interested interested = interestedRepository.findByFederalRegistration(form.getInterestedFederalRegistration());
		Realtor realtor = realtorRepository.findByCreci(form.getRealtorCreci());

		Schedule schedule = new Schedule(dateFormat, interested, realtor);

		repository.save(schedule);

		return schedule;
	}

	@Transactional
	public boolean updateSchedule(Long id, ScheduleForm form) throws ParseException {
		Optional<Schedule> optional = repository.findById(id);

		if (optional.isPresent()) {
			update(optional.get(), form);
			return true;
		}

		return false;
	}

	@Transactional
	public boolean deleteSchedule(Long id) {
		Optional<Schedule> optional = repository.findById(id);

		if (optional.isPresent()) {
			repository.delete(optional.get());
			return true;
		}

		return false;
	}
	
	public Schedule update(Schedule schedule, ScheduleForm form) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateFormat = simpleDateFormat.parse(form.getDateOfVisit());

		Interested interested = interestedRepository.findByFederalRegistration(form.getInterestedFederalRegistration());
		Realtor realtor = realtorRepository.findByCreci(form.getRealtorCreci());

		schedule.setDateOfVisit(dateFormat);
		schedule.setInterested(interested);
		schedule.setRealtor(realtor);
		
		return schedule;
	}
}
