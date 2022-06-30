package com.example.enseignement.repository;

import com.example.enseignement.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    public List<Trainer> findByFirstNameAndLastName(String firstName, String lastname);

    public Optional<Trainer> findById(Long id);
}
