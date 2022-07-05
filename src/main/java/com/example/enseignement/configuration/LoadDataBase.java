package com.example.enseignement.configuration;

import com.example.enseignement.entity.*;
import com.example.enseignement.repository.AdressRepository;
import com.example.enseignement.repository.StudentRepository;
import com.example.enseignement.repository.SubjectRepository;
import com.example.enseignement.repository.TrainerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Configuration
public class LoadDataBase {
    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);
    private ZoneId defaultZoneId = ZoneId.systemDefault();
    private Date dateB = Date.from(LocalDate.of(2016, 8, 19).atStartOfDay(defaultZoneId).toInstant());

    @Bean
    CommandLineRunner initDatabase(SubjectRepository subjectRepository, AdressRepository adressRepository, StudentRepository studentRepository, TrainerRepository trainerRepository) {
        return args -> {
            log.info("loading data" + subjectRepository.save(new Subject("Gibson", 2, Difficulty.MOYEN)));
            log.info("loading data" + subjectRepository.save(new Subject("Math", 5, Difficulty.FACILE)));


            log.info("loading data" + adressRepository.save(new Adress("Gibson", "complement", "62223", "toto", "france")));

            Adress adress = adressRepository.save(new Adress("Alpha", "complement", "62223", "tata", "france"));
            log.info("loading data" + studentRepository.save(new Student("Mr", "titi", "toto", "fake@fake.con", adress, dateB)));

            log.info("loading data" + trainerRepository.save(new Trainer("Mr", "titi", "toto", "fake@fake.con", adress, dateB, 3, 5)));
        };
    }
}
