package com.example.enseignement.controller;

import com.example.enseignement.entity.Person;
import com.example.enseignement.entity.Trainer;
import com.example.enseignement.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/lastname/{lastname}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Person> findByLastName(@PathVariable String lastname) {
        return this.personService.findAllByLastName(lastname);
    }

    @GetMapping("/city/{city}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Person> findByCity(@PathVariable String city) {
        return this.personService.findAllByCity(city);
    }

    @GetMapping("/trainers")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Trainer> findTrainer() {
        return this.personService.findTrainer();
    }








}
