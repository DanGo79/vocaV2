package com.voca.backend.service;

import com.voca.backend.Entity.UserVocaAssignment;
import com.voca.backend.repository.UserVocaAssignmentRepo;
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

    public UserVocaAssignmentService(UserVocaAssignmentRepo userVocabularyAssignmentRepo) {
        this.userVocabularyAssignmentRepo = userVocabularyAssignmentRepo;
    }

    public String addAssignment(UserVocaAssignmentRequest userVocabularyAssignmentRequest){
        Optional<UserVocaAssignment> userVocabularyAssignment =
                userVocabularyAssignmentRepo.findDistinctByUserIdAndVocabularyId(
                        userVocabularyAssignmentRequest.getUserId(),
                        userVocabularyAssignmentRequest.getVocabularyId());
        if (userVocabularyAssignment.isPresent()) {
            return "Die Vokabel befindet sich bereits in deiner Liste.";
        } else {
            UserVocaAssignment userVocaAssignment = new UserVocaAssignment();
            userVocaAssignment.setUserId(userVocabularyAssignmentRequest.getUserId());
            userVocaAssignment.setVocabularyId((userVocabularyAssignmentRequest.getVocabularyId()));
            try {
                userVocabularyAssignmentRepo.save(userVocaAssignment);
            } catch (Exception exc) {
                System.out.println("Listen der Vokabel fehlgeschlagen");
            }
            return "Die Vokabel wurde deiner Liste hinzugefügt.";
        }
    }

    public String changeList(UserVocaAssignmentRequest userVocaAssignmentRequest) {
        Optional<UserVocaAssignment> userVocaAssignment = userVocabularyAssignmentRepo.findById(userVocaAssignmentRequest.getId());
        userVocaAssignment.get().setLernen_gelernt(userVocaAssignmentRequest.getLernen_gelernt());
        userVocabularyAssignmentRepo.save(userVocaAssignment.get());
        return "Die Vokabel wurde verschoben.";
    }

    public String deleteAssignment(UserVocaAssignmentRequest userVocaAssignmentRequest) {
        userVocabularyAssignmentRepo.deleteById(userVocaAssignmentRequest.getId());
        return "Die Vokabel wurde aus deiner Liste gelöscht.";
    }

//    public List getAssignmentList(UserVocaAssignmentRequest userVocaAssignmentRequest) {
//        //return userVocabularyAssignmentRepo.findDistinctByUserIdAndLernen_gelernt(userVocaAssignmentRequest.getUserId(), userVocaAssignmentRequest.getLernen_gelernt());
//
//    }


}
