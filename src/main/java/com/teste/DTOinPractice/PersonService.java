package com.teste.DTOinPractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person create(Person person) {
        person.setId(null);
        return personRepository.save(person);
    }

    public List<PersonDTO> findAll() {
        List<Person> people = personRepository.findAll();
        return people.stream().map(person -> new PersonDTO(person.getId(), person.getName())).collect(Collectors.toList());
    }
}
