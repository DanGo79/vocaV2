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
@RequestMapping(path = "/Assignment")
public class UserVocaAssignmentController {

    @Autowired
    private final UserVocaAssignmentService userVocaAssignmentService;

    public UserVocaAssignmentController(UserVocaAssignmentService userVocaAssignmentService) {
        this.userVocaAssignmentService = userVocaAssignmentService;
    }

    @PostMapping(path = "/addAssignment")
    public String addAssignment(@RequestBody UserVocaAssignmentRequest userVocaAssignmentRequest) {
        return userVocaAssignmentService.addAssignment(userVocaAssignmentRequest);
    }

    @PutMapping(path = "/changeList")
    public String changeList(@RequestBody UserVocaAssignmentRequest userVocaAssignmentRequest) {
        return userVocaAssignmentService.changeList(userVocaAssignmentRequest);
    }

    @DeleteMapping(path = "/deleteAssignment")
    public String deleteAssignment(UserVocaAssignmentRequest userVocaAssignmentRequest) {
        return userVocaAssignmentService.deleteAssignment(userVocaAssignmentRequest);
    }

    @GetMapping(path = "/getAssignmentList")
    public List getAssignmentList(@RequestBody UserVocaAssignmentRequest userVocaAssignmentRequest) {
        return userVocaAssignmentService.getAssignmentList(userVocaAssignmentRequest);
    }


}

