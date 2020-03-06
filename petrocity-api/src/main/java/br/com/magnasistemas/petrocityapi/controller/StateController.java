package br.com.magnasistemas.petrocityapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magnasistemas.petrocityapi.model.State;
import br.com.magnasistemas.petrocityapi.repository.StateRepository;

@RestController
@RequestMapping("/statesAPI")
public class StateController {

	@Autowired
	private StateRepository stateRepository;

	@GetMapping
	@CrossOrigin(origins = "*")
	@Cacheable(value = "listStates")
	public List<State> listStates() {
		return stateRepository.findAll();
	}
}
