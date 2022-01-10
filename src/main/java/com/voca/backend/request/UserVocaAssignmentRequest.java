package com.voca.backend.request;

public class UserVocaAssignmentRequest {

    private Integer id;
    private boolean lernenGelernt;

    public UserVocaAssignmentRequest() {
    }

    public boolean getLernenGelernt() {
        return lernenGelernt;
    }

    public Integer getId() {
        return id;
    }
}
