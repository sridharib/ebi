package com.ebi.person_service.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebi.person_service.dto.PersonDTO;
import com.ebi.person_service.service.PersonService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class PersonServiceAPI {

	private PersonService personService;

	public PersonServiceAPI(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping("/person")
	public ResponseEntity<List<PersonDTO>> fetchAll() {
		return ResponseEntity.ok(personService.fetchAll());
	}

	@GetMapping("/person/{id}")
	public ResponseEntity<PersonDTO> fetch(@PathVariable Long id) {
		return ResponseEntity.ok(personService.fetch(id));
	}

	@PostMapping("/person")
	public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO person) {
		return ResponseEntity.ok(personService.createOrUpdate(person));
	}

	@PutMapping("/person")
	public ResponseEntity<PersonDTO> update(@RequestBody PersonDTO person) {
		return ResponseEntity.ok(personService.createOrUpdate(person));
	}

	@DeleteMapping("/person/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		personService.delete(id);
		return ResponseEntity.ok(String.format("Person with id %s deleted successfully", id));
	}

}
