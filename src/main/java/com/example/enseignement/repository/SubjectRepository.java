package com.example.enseignement.repository;

import com.example.enseignement.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    public List<Subject> findByDifficultyAndDuration(String difficulty, int duration);

    public Optional<Subject> findById(Long id);
}
