package com.voca.backend.service;

import com.voca.backend.Entity.User;
import com.voca.backend.repository.UserRepo;
import com.voca.backend.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User userRegistration(User user) {
        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalStateException("Die Email ist bereits vergeben!");

        } else if (userRepo.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalStateException("Der Username ist bereits vergeben!");

        } else {
            userRepo.save(user);
            return user;
        }
    }

    public User registration(UserRequest userRequest) {
        return userRegistration(new User(
                userRequest.getUsername(),
                userRequest.getEmail(),
                userRequest.getPassword()
        ));
    }

    public User getUser(UserRequest userRequest) {

        Optional<User> foundByUsername = userRepo.findByUsername(userRequest.getUsername());
        if (foundByUsername.isPresent()) {
            if (Objects.equals(foundByUsername.get().getPassword(), userRequest.getPassword())) {
                return foundByUsername.get();
            } else {
                throw new IllegalStateException("Das Passwort ist falsch!");
            }
        }

        Optional<User> foundByEmail = userRepo.findByEmail(userRequest.getUsername());
        if (foundByEmail.isPresent()) {
            if (Objects.equals(foundByEmail.get().getPassword(), userRequest.getPassword())) {
                return foundByEmail.get();
            } else {
                throw new IllegalStateException("Das Passwort ist falsch!");
            }
        }
        throw new IllegalStateException("Benutzer oder Email gibt es nicht!");

    }

    public String deleteUser(UserRequest userRequest) {
        userRepo.deleteById(userRequest.getId());
        return "Der Benutzer wurde gelöscht.";
    }

    public User putUser(UserRequest userRequest) {
        Optional<User> foundUserOp = userRepo.findById(userRequest.getId());
        if (foundUserOp.isPresent()) {
            User foundUser = foundUserOp.get();
            if (userRequest.getUsername() != null) {
                foundUser.setUsername(userRequest.getUsername());
            }
//            if (userRequest.getEmail() != null) {
//                foundUser.setEmail(userRequest.getEmail());
//            }
            if (userRequest.getPassword() != null) {
                foundUser.setPassword(userRequest.getPassword());
            }
            userRepo.save(foundUser);
            return foundUser;
        }
        return null;
    }


}