package com.example.enseignement.repository;

import com.example.enseignement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstNameAndLastName(String firstName, String lastname);

    public Optional<Student> findById(Long id);
}
