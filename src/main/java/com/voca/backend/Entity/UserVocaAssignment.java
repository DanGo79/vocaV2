package com.voca.backend.Entity;


import javax.persistence.*;

@Entity
@Table(name = "UserVocaAssignment")
public class UserVocaAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer vocaId;
    private Integer lernenGelernt = 1;

    public UserVocaAssignment() {
    }

    public UserVocaAssignment(Integer userId, Integer vocabularyId) {
        this.userId = userId;
        this.vocaId = vocabularyId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getVocabularyId() {
        return vocaId;
    }

    public Integer getLernen_gelernt() {
        return lernenGelernt;
    }

    public void setLernen_gelernt(Integer lernen_gelernt) {
        this.lernenGelernt = lernen_gelernt;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setVocabularyId(Integer vocabularyId) {
        this.vocaId = vocabularyId;
    }
}
