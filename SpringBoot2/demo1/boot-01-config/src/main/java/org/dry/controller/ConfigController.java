package org.dry.controller;

import org.dry.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
    @Autowired
    Person person;

    @RequestMapping("/person")
    public Person yaml(){
        return person;
    }
}
