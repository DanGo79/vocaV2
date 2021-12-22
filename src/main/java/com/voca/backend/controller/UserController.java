package com.voca.backend.controller;


import com.voca.backend.Entity.User;
import com.voca.backend.request.UserRequest;
import com.voca.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/User")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/userRegistration")
    public String userRegistration(@RequestBody UserRequest userRequest) {
        return userService.registration(userRequest);

    }

    @GetMapping(path = "/getUser")
    public User getUser(@RequestBody UserRequest userRequest) {
        return userService.getUser(userRequest);
    }
}
