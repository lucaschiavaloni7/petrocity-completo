package br.com.magnasistemas.petrocityapi.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.petrocityapi.controller.form.InterestedForm;
import br.com.magnasistemas.petrocityapi.model.Interested;
import br.com.magnasistemas.petrocityapi.repository.InterestedRepository;
import br.com.magnasistemas.petrocityapi.rpc.CordaRPC;

@Service

public class InterestedService {
	@Autowired
	private InterestedRepository repository;
	private CordaRPC cordaRP = new CordaRPC();

	public List<Interested> listAllInterested() {
		return repository.findAll();
	}

	public Interested findInterestedByFederalRegistration(String federalRegistration) {
		return repository.findByFederalRegistration(federalRegistration);
	}

	public Interested findInterestedById(Long id) {
		Optional<Interested> optional = repository.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		}

		return null;
	}

	@Transactional
	public Interested registerInterested(InterestedForm form) {
		Interested interested = form.converter();
		
		
		repository.save(interested);
		 
		//TODO PONTO DE CHAMADA DO CORDA
		
		interested.getName();
		interested.getCity();
		
		
//		System.out.println(cordaRP.startRPC("flow start PetrocityIssueInitiator banco: bancoCentral, interessado: interessado,"
//			+ " cliente: "XP Investimentos", valor: 100, empreendimento: "Petrocity", localizacao: "Sao Paulo"));
		
		//exibir retorno da RPC na tela (??)
		


		return interested;
	}

	@Transactional
	public boolean updateInterested(Long id, InterestedForm form) {
		Optional<Interested> optional = repository.findById(id);

		if (optional.isPresent()) {
			form.update(optional.get());
			return true;
		}

		return false;
	}

	@Transactional
	public boolean deleteInterested(Long id) {
		Optional<Interested> optional = repository.findById(id);

		if (optional.isPresent()) {
			repository.delete(optional.get());
			return true;
		}

		return false;
	}
}
