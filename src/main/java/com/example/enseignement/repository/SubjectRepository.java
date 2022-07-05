package com.example.enseignement.repository;

import com.example.enseignement.entity.Difficulty;
import com.example.enseignement.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findAllByDifficulty(@Param("dif") Difficulty difficulty);

    List<Subject> findAllByName(String name);
}
