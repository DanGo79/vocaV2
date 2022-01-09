package com.voca.backend.request;


public class VocabularyRequest {

    private Integer vocaId;
    private String nameEnglish;
    private String nameGerman;


    public VocabularyRequest() {
    }

    public VocabularyRequest(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }


    public String getNameEnglish() {
        return nameEnglish;
    }

    public String getNameGerman() {
        return nameGerman;
    }

    public Integer getId() {
        return vocaId;
    }
}
