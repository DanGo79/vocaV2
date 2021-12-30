package com.voca.backend.config;

import com.voca.backend.Entity.Vocabulary;
import com.voca.backend.repository.UserVocaAssignmentRepo;
import com.voca.backend.repository.VocabularyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class UserVocaAssignmentConfig {

    @Configuration
    public class VocabularyConfig {

        @Autowired
        private final UserVocaAssignmentRepo userVocaAssignmentRepo;

        public VocabularyConfig(UserVocaAssignmentRepo userVocaAssignmentRepo) {
            this.userVocaAssignmentRepo = userVocaAssignmentRepo;
        }


    }
}
