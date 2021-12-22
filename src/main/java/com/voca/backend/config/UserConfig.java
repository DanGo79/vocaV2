package com.voca.backend.config;

import com.voca.backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Autowired
    private final UserRepo userRepo;

    public UserConfig(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
}





