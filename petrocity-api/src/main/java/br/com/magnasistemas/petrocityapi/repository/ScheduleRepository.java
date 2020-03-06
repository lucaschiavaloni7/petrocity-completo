package br.com.magnasistemas.petrocityapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magnasistemas.petrocityapi.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
