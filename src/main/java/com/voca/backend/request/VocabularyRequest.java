package com.voca.backend.request;


public class VocabularyRequest {

    private String nameEnglish;
    private String targetLanguage;

    public VocabularyRequest(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public VocabularyRequest() {
    }

    public String getNameEnglish() {
        return nameEnglish;
    }
}
