package com.example.enseignement.repository;

import com.example.enseignement.entity.Person;
import com.example.enseignement.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByLastName(String lastName);

    @Query("select p from Person p where p.adress.city = :city")
    List<Person> findAllByCity(@Param("city") String city);

    @Query("select f from Trainer f")
    List<Trainer> findTrainer();

}
