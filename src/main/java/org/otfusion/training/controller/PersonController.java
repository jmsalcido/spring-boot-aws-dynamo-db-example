package org.otfusion.training.controller;

import org.otfusion.training.model.person.Person;
import org.otfusion.training.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("persons")
public class PersonController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Person> index() {
        logger.info("Getting all persons");

        return personService.getAll();
    }

    @PostMapping("/")
    @ResponseBody
    public Person addPerson(@RequestBody Person person) {
        return personService.add(person);
    }

}
