package com.ebi.person_service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ebi.person_service.dto.PersonDTO;
import com.ebi.person_service.entity.Person;
import com.ebi.person_service.repository.PersonRepository;

public class PersonServiceTest {

	private PersonService personService;

	private PersonRepository personRepository;

	@BeforeEach
	protected void setUpBeforeEach() {
		personRepository = mock(PersonRepository.class);
		personService = new PersonService(personRepository);

	}

	@Test
	public void testCreateOrUpdate() {

		Person person = new Person();
		person.setId(1);
		person.setAge(30);
		person.setFavoriteColor("Blue");
		person.setFirstName("Joe");
		person.setLastName("Bloggs");
		when(personRepository.save(any(Person.class))).thenReturn(person);

		PersonDTO personDTO = personService.createOrUpdate(new PersonDTO());

		assertEquals(person.getId(), personDTO.getId());
		assertEquals(person.getFirstName(), personDTO.getFirstName());
		assertEquals(person.getLastName(), personDTO.getLastName());
		assertEquals(person.getAge(), personDTO.getAge());
		assertEquals(person.getFavoriteColor(), personDTO.getFavoriteColor());
	}

	@Test
	public void testFetch() {

		Person person = new Person();
		person.setId(1);
		person.setAge(30);
		person.setFavoriteColor("Blue");
		person.setFirstName("Joe");
		person.setLastName("Bloggs");
		when(personRepository.findById(1l)).thenReturn(Optional.of(person));

		PersonDTO personDTO = personService.fetch(1l);

		assertEquals(person.getId(), personDTO.getId());
		assertEquals(person.getFirstName(), personDTO.getFirstName());
		assertEquals(person.getLastName(), personDTO.getLastName());
		assertEquals(person.getAge(), personDTO.getAge());
		assertEquals(person.getFavoriteColor(), personDTO.getFavoriteColor());
	}

	@Test
	public void testFetchAll() {

		Person person = new Person();
		person.setId(1);
		person.setAge(30);
		person.setFavoriteColor("Blue");
		person.setFirstName("Joe");
		person.setLastName("Bloggs");
		when(personRepository.findAll()).thenReturn(Arrays.asList(person));

		List<PersonDTO> persons = personService.fetchAll();

		assertNotNull(persons);
		assertEquals(1, persons.size());

		PersonDTO personDTO = persons.get(0);

		assertEquals(person.getId(), personDTO.getId());
		assertEquals(person.getFirstName(), personDTO.getFirstName());
		assertEquals(person.getLastName(), personDTO.getLastName());
		assertEquals(person.getAge(), personDTO.getAge());
		assertEquals(person.getFavoriteColor(), personDTO.getFavoriteColor());
	}

	@Test
	public void testDelete() {

		doNothing().when(personRepository).deleteById(1l);

		personService.delete(1l);
		verify(personRepository).deleteById(1l);
	}

}
