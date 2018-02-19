package org.otfusion.training.repository.person;

import org.otfusion.training.model.person.Person;

import java.util.List;

public interface PersonRepository {

    Person add(Person person);

    List<Person> getAll();

}
