package com.voca.backend.request;

import javax.persistence.Column;

public class UserRequest {

    private String username;
    private String email;
    private String password;

    public UserRequest() {
    }

    public UserRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
