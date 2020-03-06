package br.com.magnasistemas.petrocityapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magnasistemas.petrocityapi.model.State;

public interface StateRepository extends JpaRepository<State, Long> {

}
