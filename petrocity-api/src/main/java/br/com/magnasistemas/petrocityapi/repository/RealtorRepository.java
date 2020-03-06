package br.com.magnasistemas.petrocityapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magnasistemas.petrocityapi.model.Realtor;

public interface RealtorRepository extends JpaRepository<Realtor, Long> {

	Realtor findByCreci(String creci);

}
