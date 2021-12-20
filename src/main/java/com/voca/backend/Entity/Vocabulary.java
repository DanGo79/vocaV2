package com.voca.backend.Entity;


import javax.persistence.*;

@Entity
@Table(name = "Vocabulary")
public class Vocabulary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nameEnglish;
    private String nameGerman;
    @Lob
    private byte[] profilBild;



    public Vocabulary(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public Vocabulary(String nameEnglish, String nameGerman) {
        this.nameEnglish = nameEnglish;
        this.nameGerman = nameGerman;
    }

    public Integer getId() {
        return id;
    }

    public String getNameEnglish() {
        return nameEnglish;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public String getNameGerman() {
        return nameGerman;
    }

    public void setNameGerman(String nameGerman) {
        this.nameGerman = nameGerman;
    }

    public byte[] getProfilBild() {
        return profilBild;
    }

    public void setProfilBild(byte[] profilBild) {
        this.profilBild = profilBild;
    }
}
