package org.otfusion.training.controller;

import org.otfusion.training.model.person.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/")
    public String index() {
        logger.info("index hit");
        return "index";
    }

    @GetMapping(value = "owner", produces = "application/json")
    @ResponseBody
    public Person owner() {
        Person person = new Person();
        person.setFirstName("Jose");
        person.setLastName("Salcido");
        person.setAge(27);

        return person;
    }

}
