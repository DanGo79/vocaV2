package com.voca.backend.service;

import com.voca.backend.Entity.User;
import com.voca.backend.Entity.UserVocaAssignment;
import com.voca.backend.Entity.Vocabulary;
import com.voca.backend.repository.UserRepo;
import com.voca.backend.repository.UserVocaAssignmentRepo;
import com.voca.backend.repository.VocabularyRepo;
import com.voca.backend.request.UserRequest;
import com.voca.backend.request.UserVocaAssignmentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public String createAssignment(UserVocaAssignmentRequest userVocabularyAssignmentRequest) {

        Optional<User> user = userRepo.findById(userVocabularyAssignmentRequest.getUserId());
        User userGet = user.get();
        Optional<Vocabulary> vocabulary = vocabularyRepo.findById(userVocabularyAssignmentRequest.getVocaId());
        Vocabulary vocabularyGet = vocabulary.get();

        Optional<UserVocaAssignment> userVocabularyAssignment =
                userVocabularyAssignmentRepo.findDistinctByUserAndVocabulary(userGet, vocabularyGet);
        if (userVocabularyAssignment.isPresent()) {
            return "Die Zuordnung befindet sich bereits in deiner Liste.";
        } else {
            UserVocaAssignment userVocaAssignment = new UserVocaAssignment();
            userVocaAssignment.setUser(userGet);
            userVocaAssignment.setVocabulary(vocabularyGet);
            try {
                userVocabularyAssignmentRepo.save(userVocaAssignment);
            } catch (Exception exc) {
                System.out.println("Speicher der Zuordnung fehlgeschlagen");
                return "Speicher der Zuordnung fehlgeschlagen";
            }
            return "Die Vokabel wurde deiner Liste hinzugefügt.";
        }
    }

    public String changeList(UserVocaAssignmentRequest userVocabularyAssignmentRequest) {

        Optional<User> user = userRepo.findById(userVocabularyAssignmentRequest.getUserId());
        User userGet = user.get();
        Optional<Vocabulary> vocabulary = vocabularyRepo.findById(userVocabularyAssignmentRequest.getVocaId());
        Vocabulary vocabularyGet = vocabulary.get();

        Optional<UserVocaAssignment> userVocabularyAssignment =
                userVocabularyAssignmentRepo.findDistinctByUserAndVocabulary(userGet, vocabularyGet);
        if (userVocabularyAssignment.isPresent()) {
            UserVocaAssignment userVocaAssignmentGet = userVocabularyAssignment.get();
            userVocaAssignmentGet.setLernenGelernt(userVocabularyAssignmentRequest.getLernenGelernt());
            try {
                userVocabularyAssignmentRepo.save(userVocaAssignmentGet);
            } catch (Exception exc) {
                System.out.println("Speicher der Zuordnung fehlgeschlagen");
                return "Speicher der Zuordnung fehlgeschlagen";
            }
            return "Die Zuordnung wurde geändert.";

        } else {
            return "Die Zuordnung mit der Nummer gibt es schon";
        }
    }


    public String deleteAssignment(UserVocaAssignmentRequest userVocaAssignmentRequest) {
        userVocabularyAssignmentRepo.deleteUserVocaAssignmentByUserIdAndVocaId(userVocaAssignmentRequest.getUserId(), userVocaAssignmentRequest.getVocaId());

        return "Die Vokabel wurde aus deiner Liste gelöscht.";
    }

    public List getAssignmentList(UserVocaAssignmentRequest userVocaAssignmentRequest, Integer userId) {
        return userVocabularyAssignmentRepo.findAllByUserAndLernenGelernt(userId, userVocaAssignmentRequest.getLernenGelernt());


    }


}
