package br.com.magnasistemas.petrocityapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magnasistemas.petrocityapi.model.City;
import br.com.magnasistemas.petrocityapi.repository.CityRepository;

@RestController
@RequestMapping("/citiesAPI")
public class CityContoller {
	
	@Autowired
	private CityRepository cityRepository;

	@GetMapping("/{state}")
	@CrossOrigin(origins = "*")
	@Cacheable(value = "listCities")
	public List<City> listCities(@PathVariable String state) throws Exception {
		return cityRepository.findByState(state);
	}

}
