package com.voca.backend.request;


public class VocabularyRequest {

    private String nameEnglish;
    private String nameGerman;


    public VocabularyRequest() {
    }

    public VocabularyRequest(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

//    public VocabularyRequest(String nameEnglish, String nameGerman) {
//        this.nameEnglish = nameEnglish;
//        this.nameGerman = nameGerman;
//    }

    public String getNameEnglish() {
        return nameEnglish;
    }

    public String getNameGerman() {
        return nameGerman;
    }
}
