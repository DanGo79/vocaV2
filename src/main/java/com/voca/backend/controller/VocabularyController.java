package com.voca.backend.controller;

import com.voca.backend.Entity.Vocabulary;
import com.voca.backend.request.VocabularyRequest;
import com.voca.backend.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/Vocabulary")
public class VocabularyController {

    @Autowired
    private final VocabularyService vocabularyService;

    public VocabularyController(VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }

    @GetMapping(path = "/getVocabularyList")
    public List vocabularyList() {
        return vocabularyService.getVocabularyList();
    }

    @GetMapping("/searchEnglish")
    public Vocabulary searchEnglish(@RequestBody VocabularyRequest vocabularyRequest){
        return vocabularyService.searchEnglish(vocabularyRequest);
    }

    @PostMapping(path = "/addVocabulary")
    public Vocabulary addVocabulary(@RequestBody VocabularyRequest vocabularyRequest) {
        return vocabularyService.addVocabulary(vocabularyRequest);
    }

    @DeleteMapping(path = "/deleteVocabulary")
    public String deleteVocabulay(@RequestBody VocabularyRequest vocabularyRequest) {
        return vocabularyService.deleteVocabulay(vocabularyRequest);
    }

    @PutMapping(path = "/putVocabulary")
    public Vocabulary putVocabulary(@RequestBody VocabularyRequest vocabularyRequest) {
        return vocabularyService.putVocabulary(vocabularyRequest);
    }
}


