package com.voca.backend.service;


import com.voca.backend.Entity.Vocabulary;
import com.voca.backend.repository.VocabularyRepo;
import com.voca.backend.request.VocabularyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VocabularyService {

    @Autowired
    private final VocabularyRepo vocabularyRepo;

    public VocabularyService(VocabularyRepo vocabularyRepo) {
        this.vocabularyRepo = vocabularyRepo;
    }

    public String searchEnglishVocabulary(Vocabulary vocabularySearch) {

        Optional<Vocabulary> foundVocabulary = vocabularyRepo.findByNameEnglish(vocabularySearch.getNameEnglish());
        if (foundVocabulary.isPresent()) {
            return foundVocabulary.get().getNameGerman();
        } else {
            //rufe mit API bei DeepL das deutsche Wort ab
            // https://api-free.deepl.com/v2/translate?auth_key=9dcff541-835a-4c05-6b9c-2d7a6ed73d2b&text=Cat&target_lang=de&source_lang=en
            vocabularySearch.setNameGerman("xyz");
            try {
                vocabularyRepo.save(vocabularySearch);
            } catch (Exception exc) {
            }

            return vocabularySearch.getNameGerman();
        }
    }

    public String searchEnglish(VocabularyRequest vocabularyRequest) {
        return searchEnglishVocabulary(new Vocabulary(vocabularyRequest.getNameEnglish()));
    }

    public Vocabulary addVocabulary(VocabularyRequest vocabularyRequest) {
        Vocabulary newVocabulary = new Vocabulary(vocabularyRequest.getNameEnglish(), vocabularyRequest.getNameGerman());
        vocabularyRepo.save(newVocabulary);
        return newVocabulary;
    }

    public List getVocabularyList() {
        return vocabularyRepo.findAll();
    }

    public String deleteVocabulay(VocabularyRequest vocabularyRequest) {
        vocabularyRepo.deleteById(vocabularyRequest.getId());
        return "Die Vokabel wurde gelöscht.";
    }

    public Vocabulary putVocabulary(VocabularyRequest vocabularyRequest) {
        Optional<Vocabulary> foundVocabularyOp = vocabularyRepo.findById(vocabularyRequest.getId());
        if (foundVocabularyOp.isPresent()) {
            Vocabulary foundVocabulary = foundVocabularyOp.get();
            if (vocabularyRequest.getNameGerman() != null) {
                foundVocabulary.setNameGerman(vocabularyRequest.getNameGerman());
            }
            if (vocabularyRequest.getNameEnglish() != null) {
                foundVocabulary.setNameEnglish(vocabularyRequest.getNameEnglish());
            }
            vocabularyRepo.save(foundVocabulary);
            return foundVocabulary;
        }
        return null;
    }
}
