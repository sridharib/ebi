package com.ebi.person_service.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PersonDTOTest {

	@Test
	public void testPersonDTO() {
		PersonDTO personDTO = new PersonDTO();
		personDTO.setAge(30);
		personDTO.setFavoriteColor("Blue");
		personDTO.setFirstName("Joe");
		personDTO.setLastName("Bloggs");

		assertEquals(30, personDTO.getAge());
		assertEquals("Blue", personDTO.getFavoriteColor());
		assertEquals("Joe", personDTO.getFirstName());
		assertEquals("Bloggs", personDTO.getLastName());
	}
}
