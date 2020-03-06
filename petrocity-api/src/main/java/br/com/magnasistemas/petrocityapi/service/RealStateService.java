package br.com.magnasistemas.petrocityapi.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.petrocityapi.controller.form.RealStateForm;
import br.com.magnasistemas.petrocityapi.model.RealState;
import br.com.magnasistemas.petrocityapi.repository.RealStateRepository;

@Service
public class RealStateService {

	@Autowired
	private RealStateRepository repository;

	public List<RealState> listaAllRealStates() {
		return repository.findAll();
	}

	public Optional<RealState> findRealStateById(Long id) {
		return repository.findById(id);
	}

	@Transactional
	public RealState registerRealState(RealStateForm form) {
		RealState realState = form.converter();
		repository.save(realState);

		return realState;
	}

	@Transactional
	public boolean updateRealState(Long id, RealStateForm form) {
		Optional<RealState> optional = repository.findById(id);

		if (optional.isPresent()) {
			form.update(optional.get());
			return true;
		}

		return false;
	}

	@Transactional
	public boolean deleteRealState(Long id) {
		Optional<RealState> optional = repository.findById(id);

		if (optional.isPresent()) {
			repository.delete(optional.get());
			return true;
		}

		return false;
	}

}
