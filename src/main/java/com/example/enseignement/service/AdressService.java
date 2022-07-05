package com.example.enseignement.service;

import com.example.enseignement.entity.Adress;
import com.example.enseignement.entity.Person;
import com.example.enseignement.entity.Subject;
import com.example.enseignement.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AdressService {

    @Autowired
    private AdressRepository adressRepository;

    public List<Adress> findByCity(String city) {
        return this.adressRepository.findByCity(city);
    }

    public List<Adress> findByZipcode(String zipcode) {
        return this.adressRepository.findByZipcode(zipcode);
    }

    public List<Adress> findByCityOrZipcode(String zipcode, String city) {
        return this.adressRepository.findByCityOrZipcode(zipcode, city);
    }


    public Adress findByPerson(Long id) {
        Optional<Adress> optAdress = this.adressRepository.findByPerson(id);
        if (optAdress.isPresent()) {
            return optAdress.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
