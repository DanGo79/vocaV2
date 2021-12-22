package com.voca.backend.config;

import com.voca.backend.Entity.User;
import com.voca.backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Autowired
    private final UserRepo userRepo;

    public UserConfig(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

//    @Bean
//    CommandLineRunner commandLineRunnerUser(){
//    return args -> {
//        User user1 = new User("DanGo","dasdafd@dfas.com","Voca123");
//        userRepo.save(user1);
//    };

//}

}





