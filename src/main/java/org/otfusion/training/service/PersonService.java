package org.otfusion.training.service;

import org.otfusion.training.model.person.Person;

import java.util.List;

public interface PersonService {

    Person add(Person person);

    List<Person> getAll();
}
