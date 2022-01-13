package com.voca.backend.controller;

import com.voca.backend.Entity.UserVocaAssignment;
import com.voca.backend.repository.UserVocaAssignmentRepo;
import com.voca.backend.request.UserVocaAssignmentRequest;
import com.voca.backend.service.UserVocaAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Assignment/")
public class UserVocaAssignmentController {

    @Autowired
    private final UserVocaAssignmentService userVocaAssignmentService;

    public UserVocaAssignmentController(UserVocaAssignmentService userVocaAssignmentService) {
        this.userVocaAssignmentService = userVocaAssignmentService;
    }

    @PostMapping
    public String createAssignment(@RequestBody UserVocaAssignmentRequest userVocaAssignmentRequest) {
        return userVocaAssignmentService.createAssignment(userVocaAssignmentRequest);
    }

    @PutMapping
    public String changeList(@RequestBody UserVocaAssignmentRequest userVocaAssignmentRequest) {
        return userVocaAssignmentService.changeList(userVocaAssignmentRequest);
    }

    @DeleteMapping
    public String deleteAssignment(@RequestBody UserVocaAssignmentRequest userVocaAssignmentRequest) {
        return userVocaAssignmentService.deleteAssignment(userVocaAssignmentRequest);
    }

    @GetMapping(path = "/getAssignmentList/{userId}")
    public List getAssignmentList(@RequestBody UserVocaAssignmentRequest userVocaAssignmentRequest, @PathVariable Integer userId) {
        return userVocaAssignmentService.getAssignmentList(userVocaAssignmentRequest,userId);
    }


}

