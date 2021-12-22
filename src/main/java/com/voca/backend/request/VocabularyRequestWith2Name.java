package com.voca.backend.request;


public class VocabularyRequestWith2Name {

    private String nameEnglish;
    private String nameGerman;


    public VocabularyRequestWith2Name() {
    }

    public VocabularyRequestWith2Name(String nameEnglish, String nameGerman) {
        this.nameEnglish = nameEnglish;
        this.nameGerman = nameGerman;
    }

    public String getNameEnglish() {
        return nameEnglish;
    }

    public String getNameGerman() {
        return nameGerman;
    }
}
