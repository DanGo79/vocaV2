package com.voca.backend.repository;


import com.voca.backend.Entity.User;
import com.voca.backend.Entity.UserVocaAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByEmailAndPassword(String email,String Password);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);


    Optional<User> findById(Integer userId);


}
