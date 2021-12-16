package com.voca.backend.request;

public class VocabularyRequest {

    private String nameEnglish;

    public VocabularyRequest(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public String getNameEnglish() {
        return nameEnglish;
    }
}
