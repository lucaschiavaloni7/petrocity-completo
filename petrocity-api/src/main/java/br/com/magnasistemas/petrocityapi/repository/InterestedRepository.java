package br.com.magnasistemas.petrocityapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magnasistemas.petrocityapi.model.Interested;

public interface InterestedRepository extends JpaRepository<Interested, Long> {

	Interested findByFederalRegistration(String federalRegistration);

}
