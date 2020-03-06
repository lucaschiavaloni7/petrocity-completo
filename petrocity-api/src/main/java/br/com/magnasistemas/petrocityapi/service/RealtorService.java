package br.com.magnasistemas.petrocityapi.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.petrocityapi.controller.form.RealtorForm;
import br.com.magnasistemas.petrocityapi.model.Realtor;
import br.com.magnasistemas.petrocityapi.repository.RealtorRepository;

@Service
public class RealtorService {

	@Autowired
	private RealtorRepository repository;

	public List<Realtor> listAllRealtors() {
		return repository.findAll();
	}

	public Realtor findRealtorForCreci(String creci) {
		return repository.findByCreci(creci);
	}

	public Optional<Realtor> findRealtorById(Long id) {
		return repository.findById(id);
	}

	@Transactional
	public Realtor registerRealtor(RealtorForm form) {
		Realtor realtor = form.converter();
		repository.save(realtor);

		return realtor;
	}

	@Transactional
	public boolean updateRealtor(Long id, RealtorForm form) {
		Optional<Realtor> optional = repository.findById(id);

		if (optional.isPresent()) {
			form.update(optional.get());
			return true;
		}

		return false;
	}

	@Transactional
	public boolean deleteRealtor(Long id) {
		Optional<Realtor> optional = repository.findById(id);

		if (optional.isPresent()) {
			repository.delete(optional.get());
			return true;
		}

		return false;
	}
}
