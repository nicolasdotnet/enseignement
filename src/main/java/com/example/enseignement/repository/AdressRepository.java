package com.example.enseignement.repository;

import com.example.enseignement.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AdressRepository extends JpaRepository<Adress, Long> {

    List<Adress> findByCity(String city);

    List<Adress> findByZipcode(String zipcode);

    List<Adress> findByCityOrZipcode(String city, String zipcode);

    @Query("select p.adress from Person p where p.id = :id")
    Optional<Adress> findByPerson(@Param("id") Long id);
}
