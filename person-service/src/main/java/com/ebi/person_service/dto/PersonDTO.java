package com.ebi.person_service.dto;

import lombok.Data;

@Data
public class PersonDTO {

	private long id;

	private String firstName;

	private String lastName;

	private Integer age;

	private String favoriteColor;

}
