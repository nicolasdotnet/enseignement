package com.example.enseignement.service;

import com.example.enseignement.entity.Difficulty;
import com.example.enseignement.entity.Subject;
import com.example.enseignement.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> findAll() {
        return this.subjectRepository.findAll();

    }

    public Subject findById(Long id) {

        Optional<Subject> optSubject = this.subjectRepository.findById(id);
        if (optSubject.isPresent()) {
            return optSubject.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Subject create(Subject subject) {

        return this.subjectRepository.save(subject);
    }

    public Subject update(Subject subject) {

        if (!this.subjectRepository.existsById(subject.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver le subject a mettre à jour");
        }

        return this.subjectRepository.save(subject);
    }

    public Subject delete(Long id) {

        if (!this.subjectRepository.existsById(id)) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le subject à supprimer");
        }

        Subject subjectDelete = this.findById(id);
        this.subjectRepository.deleteById(id);

        if (this.subjectRepository.existsById(id)) {

            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Error lors de la suppression de la guitare");
        }
        return subjectDelete;
    }

    public List<Subject> findByName(String name) {

        return this.subjectRepository.findAllByName(name);
    }

    public List<Subject> findByDifficulty(Difficulty difficulty) {

        return this.subjectRepository.findAllByDifficulty(difficulty);
    }
}
