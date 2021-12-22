package com.voca.backend.Entity;


import javax.persistence.*;

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
    private Integer password;
    @Column(unique = true)
    private String email;

    public User(String username, Integer password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
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

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getAdresse() {
        return adresse;
    }

    public Integer getPassword() {
        return password;
    }
}
