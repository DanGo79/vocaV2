package com.voca.backend.Entity;


import javax.persistence.*;

@Entity
@Table(name = "UserVocaAssignment")
public class UserVocaAssignment {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    UserVocaAssignmentKey id;

    @ManyToOne
    @MapsId("vocaId")
    @JoinColumn(name = "voca_id")
    private Vocabulary vocabulary;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    private boolean lernenGelernt = true;

    public UserVocaAssignment() {
    }

    public UserVocaAssignment(boolean lernenGelernt) {
        this.lernenGelernt = lernenGelernt;
    }

    public UserVocaAssignmentKey getId() {
        return id;
    }

    public void setId(UserVocaAssignmentKey id) {
        this.id = id;
    }

    public Vocabulary getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(Vocabulary vocabulary) {
        this.vocabulary = vocabulary;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLernenGelernt() {
        return lernenGelernt;
    }

    public void setLernenGelernt(boolean lernenGelernt) {
        this.lernenGelernt = lernenGelernt;
    }

}
