package com.voca.backend.controller;

import com.voca.backend.Entity.Vocabulary;
import com.voca.backend.request.VocabularyRequest;
import com.voca.backend.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/search")
public class Controller {

    @Autowired
    private final VocabularyService vocabularyService;

    public Controller(VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }

    @GetMapping(path = "/getVocabularyList")
    public List vocabularyList() {
        return vocabularyService.getVocabularyList();
    }

    @GetMapping("/searchEnglish/{nameEnglish}")
    public String searchEnglish(@PathVariable String nameEnglish) {
        VocabularyRequest vr = new VocabularyRequest(nameEnglish);
        return vocabularyService.searchEnglish(vr);
    }

    @PostMapping(path = "/addVocabulary")
    public Vocabulary addVocabulary(@RequestBody VocabularyRequest vocabularyRequest) {
        return vocabularyService.addVocabulary(vocabularyRequest);
    }

    @DeleteMapping(path = "/deleteVocabulay/{id}")
    public void deleteVocabulay(@PathVariable Integer id) {
        vocabularyService.deleteVocabulay(id);
    }


    /*
    @GetMapping(value = "/searchEnglish", consumes = {"application/json"})
    public String searchEnglish(@RequestBody VocabularyRequest vocabularyRequest) {
        return vocabularyService.searchEnglish(vocabularyRequest);
    }
*/

}


