package com.voca.backend.controller;

import com.voca.backend.request.VocabularyRequest;
import com.voca.backend.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/search")
public class Controller {

    @Autowired
    private final VocabularyService vocabularyService;

    public Controller(VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }

    @GetMapping(path = "/")
    public String hello() {
        return "hallo";
    }

    @PostMapping(path = "/searchEnglish")
    public String searchEnglish(@RequestBody VocabularyRequest vocabularyRequest) {
        return vocabularyService.searchEnglish(vocabularyRequest);
    }


}


