package com.ebi.person_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ebi.person_service.dto.PersonDTO;
import com.ebi.person_service.entity.Person;
import com.ebi.person_service.repository.PersonRepository;

@Service
public class PersonService {

	private ModelMapper modelMapper = new ModelMapper();

	private PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public PersonDTO createOrUpdate(PersonDTO personDTO) {
		Person person = modelMapper.map(personDTO, Person.class);
		person = personRepository.save(person);
		return modelMapper.map(person, PersonDTO.class);
	}

	public PersonDTO fetch(Long id) {
		Person person = personRepository.findById(id).orElse(null);
		return modelMapper.map(person, PersonDTO.class);
	}

	public List<PersonDTO> fetchAll() {
		return personRepository.findAll().stream().map(person -> modelMapper.map(person, PersonDTO.class))
				.collect(Collectors.toList());
	}

	public void delete(Long id) {
		personRepository.deleteById(id);
	}

}
