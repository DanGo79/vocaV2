package com.voca.backend.Entity;


import javax.persistence.*;

@Entity
@Table(name = "UserVocabularyAssignment")
public class UserVocaAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer vocabularyId;
    private Integer lernen_gelernt = 1;

    public UserVocaAssignment() {
    }

    public UserVocaAssignment(Integer userId, Integer vocabularyId) {
        this.userId = userId;
        this.vocabularyId = vocabularyId;
    }

    public Integer getId() {
        return id;
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

    public void setLernen_gelernt(Integer lernen_gelernt) {
        this.lernen_gelernt = lernen_gelernt;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setVocabularyId(Integer vocabularyId) {
        this.vocabularyId = vocabularyId;
    }
}
