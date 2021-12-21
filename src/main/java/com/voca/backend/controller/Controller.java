package com.voca.backend.controller;

import com.voca.backend.request.VocabularyRequest;
import com.voca.backend.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @GetMapping("/searchEnglish/{nameEnglish}")
    public String searchEnglish(@PathVariable String nameEnglish){
        VocabularyRequest vr = new VocabularyRequest(nameEnglish);
        return vocabularyService.searchEnglish(vr);
    }

    /*
    @GetMapping(value = "/searchEnglish", consumes = {"application/json"})
    public String searchEnglish(@RequestBody VocabularyRequest vocabularyRequest) {
        return vocabularyService.searchEnglish(vocabularyRequest);
    }
*/

}


