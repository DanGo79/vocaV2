package com.voca.backend.service;


import com.voca.backend.Entity.Vocabulary;
import com.voca.backend.repository.VocabularyRepo;
import com.voca.backend.request.VocabularyRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VocabularyService {

    private final VocabularyRepo vocabularyRepo;

    public VocabularyService(VocabularyRepo vocabularyRepo) {
        this.vocabularyRepo = vocabularyRepo;
    }

    public String searchEnglishVocabulary(Vocabulary vocabularySearch) {

        Optional<Vocabulary> foundVocabulary = vocabularyRepo.findByNameEnglish(vocabularySearch.getNameEnglish());
        if(foundVocabulary.isPresent()) {
            return foundVocabulary.get().getNameGerman();
        } else {
            //rufe mit API bei DeepL das deutsche Wort ab
            vocabularySearch.setNameGerman("xyz");
           try {
               vocabularyRepo.save(vocabularySearch);
           } catch (Exception exc) {}

            return vocabularySearch.getNameGerman();
        }
    }

    public String searchEnglish(VocabularyRequest vocabularyRequest) {
        return searchEnglishVocabulary(new Vocabulary(vocabularyRequest.getNameEnglish()));
    }

}
