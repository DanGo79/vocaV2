package com.voca.backend.service;

import com.voca.backend.Entity.User;
import com.voca.backend.Entity.UserVocaAssignment;
import com.voca.backend.Entity.Vocabulary;
import com.voca.backend.repository.UserRepo;
import com.voca.backend.repository.UserVocaAssignmentRepo;
import com.voca.backend.repository.VocabularyRepo;
import com.voca.backend.request.UserVocaAssignmentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserVocaAssignmentService {

    @Autowired
    private final UserVocaAssignmentRepo userVocabularyAssignmentRepo;
    private final UserRepo userRepo;
    private final VocabularyRepo vocabularyRepo;

    public UserVocaAssignmentService(UserVocaAssignmentRepo userVocabularyAssignmentRepo, UserRepo userRepo, VocabularyRepo vocabularyRepo) {
        this.userVocabularyAssignmentRepo = userVocabularyAssignmentRepo;
        this.userRepo = userRepo;
        this.vocabularyRepo = vocabularyRepo;
    }

    public String createAssignment(UserVocaAssignmentRequest userVocaAssignmentRequest) {
        Optional<UserVocaAssignment> userVocabularyAssignment =
                userVocabularyAssignmentRepo.findDistinctByUserAndVocabulary(
                        findUser(userVocaAssignmentRequest),
                        findVoca(userVocaAssignmentRequest));
        if (userVocabularyAssignment.isPresent()) {
            return "Die Zuordnung befindet sich bereits in deiner Liste.";
        } else {
            UserVocaAssignment userVocaAssignment = new UserVocaAssignment();
            userVocaAssignment.setUser(findUser(userVocaAssignmentRequest));
            userVocaAssignment.setVocabulary(findVoca(userVocaAssignmentRequest));
            try {
                userVocabularyAssignmentRepo.save(userVocaAssignment);
            } catch (Exception exc) {
                System.out.println("Speicher der Zuordnung fehlgeschlagen");
                return "Speicher der Zuordnung fehlgeschlagen";
            }
            return "Die Vokabel wurde deiner Liste hinzugefügt.";
        }
    }

    public String changeList(UserVocaAssignmentRequest userVocaAssignmentRequest) {
        Optional<UserVocaAssignment> userVocabularyAssignment =
                userVocabularyAssignmentRepo.findDistinctByUserAndVocabulary(
                        findUser(userVocaAssignmentRequest),
                        findVoca(userVocaAssignmentRequest));
        if (userVocabularyAssignment.isPresent()) {
            UserVocaAssignment userVocaAssignmentGet = userVocabularyAssignment.get();
            userVocaAssignmentGet.setLernenGelernt(userVocaAssignmentRequest.getLernenGelernt());
            try {
                userVocabularyAssignmentRepo.save(userVocaAssignmentGet);
            } catch (Exception exc) {
                System.out.println("Speicher der Zuordnung fehlgeschlagen");
                return "Speicher der Zuordnung fehlgeschlagen";
            }
            return "Die Zuordnung wurde geändert.";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Assignment not found");
        }
    }

    public String deleteAssignment(UserVocaAssignmentRequest userVocaAssignmentRequest) {
        Optional<UserVocaAssignment> userVocabularyAssignment =
                userVocabularyAssignmentRepo.findDistinctByUserAndVocabulary(
                        findUser(userVocaAssignmentRequest),
                        findVoca(userVocaAssignmentRequest));
        if (userVocabularyAssignment.isPresent()) {
            try {
                userVocabularyAssignmentRepo.delete(userVocabularyAssignment.get());
            } catch (Exception exc) {
                System.out.println("Löschen der Zuordnung fehlgeschlagen");
                return "Löschen der Zuordnung fehlgeschlagen";
            }
            return "Die Zuordnung wurde gelöscht.";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Assignment not found");
        }
    }

    public List getAssignmentList(UserVocaAssignmentRequest userVocaAssignmentRequest) {
        return userVocabularyAssignmentRepo.findAllByUserAndLernenGelernt(
                findUser(userVocaAssignmentRequest)
                , userVocaAssignmentRequest.getLernenGelernt());
    }

    public User findUser(UserVocaAssignmentRequest userVocaAssignmentRequest) {
        Optional<User> user = userRepo.findById(userVocaAssignmentRequest.getUserId());
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    public Vocabulary findVoca(UserVocaAssignmentRequest userVocaAssignmentRequest) {
        Optional<Vocabulary> vocabulary = vocabularyRepo.findById(userVocaAssignmentRequest.getVocaId());
        if (vocabulary.isPresent()) {
            return vocabulary.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vocabulary not found");
        }
    }


}
