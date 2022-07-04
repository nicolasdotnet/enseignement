package com.example.enseignement.configuration;

import com.example.enseignement.entity.Subject;
import com.example.enseignement.repository.SubjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDataBase {
    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initDatabase(SubjectRepository subjectRepository){
        return args ->{
            log.info("loading data" + subjectRepository.save(new Subject("Gibson", 2,"facile" )));
            log.info("loading data" + subjectRepository.save(new Subject("Math", 5,"moyen" )));
        };
    }
}
