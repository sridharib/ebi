package com.ebi.person_service.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PersonTest {

	@Test
	public void testperson() {
		Person person = new Person();
		person.setAge(30);
		person.setFavoriteColor("Blue");
		person.setFirstName("Joe");
		person.setLastName("Bloggs");

		assertEquals(30, person.getAge());
		assertEquals("Blue", person.getFavoriteColor());
		assertEquals("Joe", person.getFirstName());
		assertEquals("Bloggs", person.getLastName());
	}
}
