package com.ebi.person_service.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.ebi.person_service.dto.PersonDTO;
import com.ebi.person_service.entity.Person;
import com.ebi.person_service.repository.PersonRepository;

@SpringBootTest
public class PersonServiceIntegrationTest {

	@Autowired
	private PersonServiceAPI personServiceAPI;

	@Autowired
	private PersonRepository personRepository;

	private Person person;

	@BeforeEach
	protected void setUpBeforeEach() {
		personRepository.deleteAll();
		person = new Person();
		person.setAge(30);
		person.setFavoriteColor("Blue");
		person.setFirstName("Joe");
		person.setLastName("Bloggs");
		personRepository.save(person);
	}

	@Test
	public void testFetchAll() {
		ResponseEntity<List<PersonDTO>> fetchAll = personServiceAPI.fetchAll();
		List<PersonDTO> persons = fetchAll.getBody();
		assertNotNull(persons);
		assertEquals(1, persons.size());
		assertEquals(person.getFirstName(), persons.get(0).getFirstName());
	}

	@Test
	public void testFetch() {
		ResponseEntity<PersonDTO> fetchAll = personServiceAPI.fetch(1l);
		PersonDTO personDTO = fetchAll.getBody();
		assertNotNull(personDTO);
		assertEquals(person.getId(), personDTO.getId());
		assertEquals(person.getFirstName(), personDTO.getFirstName());
	}

	@Test
	public void testCreate() {
		PersonDTO personDTO = new PersonDTO();
		personDTO.setAge(35);
		personDTO.setFavoriteColor("Black");
		personDTO.setFirstName("Nigel");
		personDTO.setLastName("Ryan");
		ResponseEntity<PersonDTO> fetchAll = personServiceAPI.create(personDTO);
		personDTO = fetchAll.getBody();
		assertNotNull(personDTO);
		assertNotNull(personDTO.getId());
		assertEquals("Nigel", personDTO.getFirstName());
	}

	@Test
	public void testUpdate() {
		PersonDTO personDTO = new PersonDTO();
		personDTO.setId(1);
		personDTO.setLastName("Ryan");
		ResponseEntity<PersonDTO> fetchAll = personServiceAPI.update(personDTO);
		personDTO = fetchAll.getBody();
		assertNotNull(personDTO);
		assertEquals("Ryan", personDTO.getLastName());
	}

	@Test
	public void testDelete() {
		List<Person> persons = personRepository.findAll();
		assertNotNull(persons);
		Person person2 = persons.get(0);
		assertNotNull(person2);
		
		personServiceAPI.delete(person2.getId());
		person2 = personRepository.findById(person2.getId()).orElse(null);
		assertNull(person2);
	}

}
