package br.com.magnasistemas.petrocityapi.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.magnasistemas.petrocityapi.controller.dto.InterestedDto;
import br.com.magnasistemas.petrocityapi.controller.form.InterestedForm;
import br.com.magnasistemas.petrocityapi.model.Interested;
import br.com.magnasistemas.petrocityapi.service.InterestedService;

@RestController
@RequestMapping("/empreendimentoAPI")
public class InterestedController {

	@Autowired
	private InterestedService interestedService;

	@GetMapping
	@CrossOrigin(origins = "*")
	public List<Interested> listInteresteds() {
		return interestedService.listAllInterested();
	}

	@GetMapping("/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Interested> findInterestedsById(@PathVariable Long id) {
		Interested interested = interestedService.findInterestedById(id);

		if (interested != null) {
			return ResponseEntity.ok(interested);
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@CrossOrigin(origins = "*")
	public ResponseEntity<InterestedDto> register(@RequestBody @Valid InterestedForm form,
			UriComponentsBuilder uriBuilder) {

		Interested interested = interestedService.registerInterested(form);
		URI uri = uriBuilder.path("/interesteds").buildAndExpand(interested.getFederalRegistration()).toUri();
		return ResponseEntity.created(uri).body(new InterestedDto(interested));
	}

	@PutMapping("/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Interested> update(@PathVariable Long id, @RequestBody @Valid InterestedForm form) {

		boolean updated = interestedService.updateInterested(id, form);

		if (updated) {
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	@CrossOrigin(origins = "*")
	public ResponseEntity<Interested> delete(@PathVariable Long id) {
		boolean deleted = interestedService.deleteInterested(id);

		if (deleted) {
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}
