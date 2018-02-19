package org.otfusion.training.service;

import org.otfusion.training.model.person.Person;
import org.otfusion.training.repository.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimplePersonService implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public SimplePersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person add(Person person) {
        return personRepository.add(person);
    }

    @Override
    public List<Person> getAll() {
        return personRepository.getAll();
    }
}
