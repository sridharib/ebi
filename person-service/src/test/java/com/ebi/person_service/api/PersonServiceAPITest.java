package com.ebi.person_service.api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ebi.person_service.dto.PersonDTO;
import com.ebi.person_service.service.PersonService;

public class PersonServiceAPITest {

	private PersonService personService;

	private PersonServiceAPI personServiceAPI;

	@BeforeEach
	protected void setUpBeforeEach() {
		personService = mock(PersonService.class);
		personServiceAPI = new PersonServiceAPI(personService);
	}

	@Test
	public void testFetchAll() {
		personServiceAPI.fetchAll();
		verify(personService).fetchAll();
	}

	@Test
	public void testFetch() {
		personServiceAPI.fetch(1l);
		verify(personService).fetch(1l);
	}

	@Test
	public void testCreate() {
		PersonDTO personDTO = new PersonDTO();
		personServiceAPI.create(personDTO);
		verify(personService).createOrUpdate(personDTO);
	}

	@Test
	public void testUpdate() {
		PersonDTO personDTO = new PersonDTO();
		personServiceAPI.update(personDTO);
		verify(personService).createOrUpdate(personDTO);
	}

	@Test
	public void testDelete() {
		personServiceAPI.delete(1l);
		verify(personService).delete(1l);
	}

}
