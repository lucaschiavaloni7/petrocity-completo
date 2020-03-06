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

import br.com.magnasistemas.petrocityapi.controller.dto.RealStateDto;
import br.com.magnasistemas.petrocityapi.controller.form.RealStateForm;
import br.com.magnasistemas.petrocityapi.model.RealState;
import br.com.magnasistemas.petrocityapi.service.RealStateService;

@RestController
@RequestMapping("/imoveisAPI")
public class RealStateController {

	@Autowired
	private RealStateService realStateService;

	@GetMapping
	@CrossOrigin(origins = "*")
	public List<RealState> listRealStates() {
		return realStateService.listaAllRealStates();
	}

	@PostMapping
	@CrossOrigin(origins = "*")
	public ResponseEntity<RealStateDto> register(@RequestBody @Valid RealStateForm form,
			UriComponentsBuilder uriBuilder) {
		RealState realState = realStateService.registerRealState(form);
		URI uri = uriBuilder.path("/imoveisAPI").buildAndExpand(realState.getDescription()).toUri();
		return ResponseEntity.created(uri).body(new RealStateDto(realState));
	}

	@PutMapping("/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<RealState> update(@PathVariable Long id, @RequestBody @Valid RealStateForm form) {
		boolean updated = realStateService.updateRealState(id, form);

		if (updated) {
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<RealState> delete(@PathVariable Long id) {
		boolean deleted = realStateService.deleteRealState(id);

		if (deleted) {
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}
