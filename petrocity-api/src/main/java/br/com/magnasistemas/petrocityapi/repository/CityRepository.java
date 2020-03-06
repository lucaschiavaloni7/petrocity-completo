package br.com.magnasistemas.petrocityapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magnasistemas.petrocityapi.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
	
	List<City> findByState(String state);

}
