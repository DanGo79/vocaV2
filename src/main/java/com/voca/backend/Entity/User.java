package com.voca.backend.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String vorname;
    private String nachname;
    private String adresse;
    private String username;
    private String password;
    //@Column(unique = true)
    private String email;


    @JsonIgnore
    @OneToMany(mappedBy = "user")
    Set<UserVocaAssignment> userVocaAssignment;


    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getPassword() {
        return password;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Set<UserVocaAssignment> getUserVocaAssignment() {
        return userVocaAssignment;
    }

    public void setUserVocaAssignment(Set<UserVocaAssignment> userVocaAssignment) {
        this.userVocaAssignment = userVocaAssignment;
    }
}
