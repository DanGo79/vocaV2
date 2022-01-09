package com.voca.backend.request;

public class UserVocaAssignmentRequest {

    private Integer id;
    private Integer userId;
    private Integer vocabularyId;
    private Integer lernenGelernt;

    public UserVocaAssignmentRequest() {
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getVocabularyId() {
        return vocabularyId;
    }

    public Integer getLernenGelernt() {
        return lernenGelernt;
    }

    public Integer getId() {
        return id;
    }
}
