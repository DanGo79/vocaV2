package com.voca.backend.controller;


import com.voca.backend.Entity.User;
import com.voca.backend.request.UserRequest;
import com.voca.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/User/")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public User userRegistration(@RequestBody UserRequest userRequest) {
        return userService.registration(userRequest);
    }

    @PostMapping("getUser/")
    public User getUser(@RequestBody UserRequest userRequest) {
        return userService.getUser(userRequest);
    }

    @DeleteMapping
    public String deleteUser(@RequestBody UserRequest userRequest) {
        return userService.deleteUser(userRequest);
    }

    @PutMapping
    public User putUser(@RequestBody UserRequest userRequest) {
        return userService.putUser(userRequest);
    }

}
