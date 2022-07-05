package com.example.enseignement.service;

import com.example.enseignement.entity.Person;
import com.example.enseignement.entity.Trainer;
import com.example.enseignement.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAllByLastName(String lastName) {

        return this.personRepository.findByLastName(lastName);
    }

    public List<Person> findAllByCity(String city) {

        return this.personRepository.findAllByCity(city);
    }

    public List<Trainer> findTrainer() {
        return this.personRepository.findTrainer();
    }
}
