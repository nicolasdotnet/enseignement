package com.example.enseignement.controller;

import com.example.enseignement.entity.Difficulty;
import com.example.enseignement.entity.Subject;
import com.example.enseignement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/*

classe controller pour les service de guitare
 */
@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Subject> findAll() {
        return this.subjectService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Subject findById(@PathVariable Long id) {
        return subjectService.findById(id);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Subject> findByName(@PathVariable String name) {
        return this.subjectService.findByName(name);
    }

    @GetMapping("/difficulty/{difficulty}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Subject> findByDifficulty(@PathVariable Difficulty difficulty) {
        return this.subjectService.findByDifficulty(difficulty);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Subject createSubject(@RequestBody Subject subject) {
        return this.subjectService.create(subject);
    }

    @PutMapping ("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Subject updateSubject(@PathVariable Long id, @RequestBody Subject subject) {

        if (!id.equals(subject.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mauvaise subject à maj");
        }
        return this.subjectService.update(subject);
    }
    @DeleteMapping ("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Subject deleteSubject(@PathVariable Long id) {
        return this.subjectService.delete(id);
    }




}
