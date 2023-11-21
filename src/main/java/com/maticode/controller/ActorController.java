package com.maticode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maticode.dtos.ActorDTO;
import com.maticode.dtos.ActorSearchDTO;
import com.maticode.exception.ActorException;
import com.maticode.service.ActorService;

@RestController
@RequestMapping("/actors")
public class ActorController {

	@Autowired
	private ActorService actorService;

	@GetMapping(value = "/findByActorId/{id}")
	public ActorDTO findActorById(@PathVariable("id") Long id) throws ActorException {
		return actorService.findActorById(id);
	}

	@GetMapping(value = "/findByFirstName/{firstName}")
	public List<ActorDTO> findByFirstName(@PathVariable("firstName") String firstName) throws ActorException {
		return actorService.findByFirstName(firstName);
	}

	@GetMapping(value = "/findByLastName/{lastName}")
	public List<ActorDTO> findByName(@PathVariable("lastName") String lastName) throws ActorException {
		return actorService.findByLastName(lastName);
	}

	@GetMapping(value = "/downloadPicture/{id}")
	public Resource downloadPicture(@PathVariable("id") Long id) throws ActorException {
		return actorService.downloadPicture(id);
	}

	@GetMapping(value = "/getAll")
	public List<ActorDTO> getAll() throws ActorException {
		return actorService.getAll();
	}

	@GetMapping(value = "/getAllActorsByPages")
	public Page<ActorDTO> getAllActorsByPages(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) throws ActorException {
		// Crea un objeto Pageable con los parámetros de paginación, se puede cambiar
		// "id" por la columna que se quiera, pero mi ordenacion está en el query
		// definido.
//		Pageable pageable = PageRequest.of(page, size, Sort.by("id"));

		Pageable pageable = PageRequest.of(page, size);

		return actorService.getAllActorsByPages(pageable);
	}

	@PostMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<ActorDTO>> allActorsByPost(@Validated @RequestBody ActorSearchDTO request,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		try {
			Pageable pageable = PageRequest.of(page, size);
			Page<ActorDTO> result = actorService.allActorsByPost(request, pageable);
			return ResponseEntity.ok(result);
		} catch (ActorException e) {
			e.printStackTrace();
			// Manejar la excepción apropiadamente, como enviar una respuesta de error
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
