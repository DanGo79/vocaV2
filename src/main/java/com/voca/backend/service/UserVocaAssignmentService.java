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

    public String createAssignment(UserVocaAssignmentRequest userVocabularyAssignmentRequest, Integer userId, Integer vocaId){

       Optional<User> user = userRepo.findById(userId);
       User userGet = user.get();
       Optional<Vocabulary> vocabulary = vocabularyRepo.findById(vocaId);
       Vocabulary vocabularyGet = vocabulary.get();

        Optional<UserVocaAssignment> userVocabularyAssignment =
                userVocabularyAssignmentRepo.findDistinctByUserAndVocabularyAndAndLernenGelernt(userGet, vocabularyGet, userVocabularyAssignmentRequest.getLernenGelernt());
        if (userVocabularyAssignment.isPresent()) {
            return "Die Zuordnung mit der lernenGelernt Nummer befindet sich bereits in deiner Liste.";
        } else {
            UserVocaAssignment userVocaAssignment = new UserVocaAssignment(userVocabularyAssignmentRequest.getLernenGelernt());
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

    public String changeList(UserVocaAssignmentRequest userVocaAssignmentRequest) {
        Optional<UserVocaAssignment> userVocaAssignment = userVocabularyAssignmentRepo.findById(userVocaAssignmentRequest.getId());
        userVocaAssignment.get().setLernenGelernt(userVocaAssignmentRequest.getLernenGelernt());
        userVocabularyAssignmentRepo.save(userVocaAssignment.get());
        return "Die Vokabel wurde verschoben.";
    }

    public String deleteAssignment(UserVocaAssignmentRequest userVocaAssignmentRequest) {
        userVocabularyAssignmentRepo.deleteById(userVocaAssignmentRequest.getId());
        return "Die Vokabel wurde aus deiner Liste gelöscht.";
    }

    public List getAssignmentList(UserVocaAssignmentRequest userVocaAssignmentRequest, Integer userId) {
        return userVocabularyAssignmentRepo.findAllByUserAndLernenGelernt(userId, userVocaAssignmentRequest.getLernenGelernt());




    }


}
