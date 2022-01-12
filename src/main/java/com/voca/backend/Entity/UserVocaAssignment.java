package com.voca.backend.Entity;


import javax.persistence.*;

@Entity
@Table(name = "UserVocaAssignment")
public class UserVocaAssignment {

    @EmbeddedId
    UserVocaAssignmentKey id = new UserVocaAssignmentKey();

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @MapsId("vocaId")
    @JoinColumn(name = "voca_id")
    Vocabulary vocabulary;

    Integer lernenGelernt;

    public UserVocaAssignment() {
    }

    public UserVocaAssignment(Integer lernenGelernt) {
        this.lernenGelernt = lernenGelernt;
    }

    public UserVocaAssignmentKey getId() {
        return id;
    }

    public void setId(UserVocaAssignmentKey id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vocabulary getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(Vocabulary vocabulary) {
        this.vocabulary = vocabulary;
    }

    public Integer getLernenGelernt() {
        return lernenGelernt;
    }

    public void setLernenGelernt(Integer lernenGelernt) {
        this.lernenGelernt = lernenGelernt;
    }
}
