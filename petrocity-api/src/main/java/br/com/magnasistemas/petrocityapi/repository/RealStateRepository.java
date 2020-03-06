package br.com.magnasistemas.petrocityapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magnasistemas.petrocityapi.model.RealState;

public interface RealStateRepository extends JpaRepository<RealState, Long> {

}
