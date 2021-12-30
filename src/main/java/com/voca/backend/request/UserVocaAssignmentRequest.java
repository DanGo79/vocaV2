package com.voca.backend.request;

public class UserVocaAssignmentRequest {

    private Integer id;
    private Integer userId;
    private Integer vocabularyId;
    private Integer lernen_gelernt;

    public UserVocaAssignmentRequest() {
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getVocabularyId() {
        return vocabularyId;
    }

    public Integer getLernen_gelernt() {
        return lernen_gelernt;
    }

    public Integer getId() {
        return id;
    }
}
