package com.example.enseignement.controller;

import com.example.enseignement.entity.Adress;
import com.example.enseignement.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adress")
public class AdressController {

    @Autowired
    private AdressService adressService;

    @GetMapping("/city/{city}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Adress> findByCity(@PathVariable String city) {
        return this.adressService.findByCity(city);
    }

    @GetMapping("/zipcode/{zipcode}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Adress> findByZipcode(@PathVariable String zipcode) {
        return this.adressService.findByZipcode(zipcode);
    }

    @GetMapping("/find")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Adress> findByCityOrZipcode(@RequestParam(defaultValue = "") String zipcode,
                                            @RequestParam(defaultValue = "") String city ) {

        return this.adressService.findByCityOrZipcode(city, zipcode);
    }

    @GetMapping("/person/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Adress findByPerson(@PathVariable Long id ) {

        return this.adressService.findByPerson(id);
    }


}
