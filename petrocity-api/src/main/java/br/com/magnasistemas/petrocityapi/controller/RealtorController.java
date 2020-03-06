package br.com.magnasistemas.petrocityapi.controller;

import java.net.URI;
import java.util.List;

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

import br.com.magnasistemas.petrocityapi.controller.dto.RealtorDto;
import br.com.magnasistemas.petrocityapi.controller.form.RealtorForm;
import br.com.magnasistemas.petrocityapi.model.Realtor;
import br.com.magnasistemas.petrocityapi.service.RealtorService;

@RestController
@RequestMapping("/corretorAPI")
public class RealtorController {

	@Autowired
	private RealtorService realtorService;

	@GetMapping
	@CrossOrigin(origins = "*")
	public List<Realtor> listRealtors() {
		return realtorService.listAllRealtors();
	}

	@GetMapping("/{creci}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Realtor> findRealtorForCreci(@PathVariable String creci) {
		Realtor realtor = realtorService.findRealtorForCreci(creci);

		if (realtor != null) {
			return ResponseEntity.ok(realtor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	@CrossOrigin(origins = "*")
	public ResponseEntity<RealtorDto> register(@RequestBody @Valid RealtorForm form, UriComponentsBuilder uriBuilder) {
		Realtor realtor = realtorService.registerRealtor(form);
		URI uri = uriBuilder.path("/corretorAPI").buildAndExpand(realtor.getName()).toUri();
		return ResponseEntity.created(uri).body(new RealtorDto(realtor));
	}

	@PutMapping("/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<RealtorDto> update(@PathVariable Long id, @RequestBody @Valid RealtorForm form) {

		boolean updated = realtorService.updateRealtor(id, form);

		if (updated) {
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<RealtorDto> delete(@PathVariable Long id) {
		boolean delete = realtorService.deleteRealtor(id);

		if (delete) {
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}
}
