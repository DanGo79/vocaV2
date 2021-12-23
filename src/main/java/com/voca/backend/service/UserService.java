package com.voca.backend.service;

import com.voca.backend.Entity.User;
import com.voca.backend.repository.UserRepo;
import com.voca.backend.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public String userRegistration(User user) {
        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalStateException("Die Email ist bereits vergeben");
        } else {
            userRepo.save(user);
            return "Benutzer wurde erfolgreich gespeichert.";
        }
    }

    public String registration(UserRequest userRequest) {
        return userRegistration(new User(
                userRequest.getUsername(),
                userRequest.getEmail(),
                userRequest.getPassword()
        ));
    }

    public User getUser(UserRequest userRequest) {
        if (userRequest.getUsername() != null) {
            return userRepo.findByUsername(userRequest.getUsername()).get();
        }
        if (userRequest.getEmail() != null) {
            return userRepo.findByEmail(userRequest.getEmail()).get();
        }
        return null;
    }

    public String deleteUser(UserRequest userRequest) {
        userRepo.deleteById(userRequest.getId());
        return "Der Benutzer wurde gelöscht.";
    }


}