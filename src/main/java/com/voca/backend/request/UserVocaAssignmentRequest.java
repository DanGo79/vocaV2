package com.voca.backend.request;

public class UserVocaAssignmentRequest {

    private Integer userId;
    private Integer vocaId;
    private Integer lernenGelernt;

    public UserVocaAssignmentRequest() {
    }

    public Integer getLernenGelernt() {
        return lernenGelernt;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getVocaId() {
        return vocaId;
    }
}
