package com.voca.backend.config;


import com.voca.backend.Entity.Vocabulary;
import com.voca.backend.repository.VocabularyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VocabularyConfig {

    @Autowired
    private final VocabularyRepo vocabularyRepo;

    public VocabularyConfig(VocabularyRepo vocabularyRepo) {
        this.vocabularyRepo = vocabularyRepo;
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            Vocabulary vocabulary1 = new Vocabulary("Repository", "Speicherort");


//                vocabularyRepo.saveAll(
//                        List.of(vocabulary1)
//                );

        };
    }


}
