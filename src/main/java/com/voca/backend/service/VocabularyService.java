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
            // https://api-free.deepl.com/v2/translate?auth_key=9dcff541-835a-4c05-6b9c-2d7a6ed73d2b&text=Cat&target_lang=de&source_lang=en
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
