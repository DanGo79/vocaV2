package com.voca.backend.service;


import com.voca.backend.Entity.Vocabulary;
import com.voca.backend.repository.VocabularyRepo;
import com.voca.backend.request.VocabularyRequest;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Optional;

@Service
public class VocabularyService {

    @Autowired
    private final VocabularyRepo vocabularyRepo;

    public VocabularyService(VocabularyRepo vocabularyRepo) {
        this.vocabularyRepo = vocabularyRepo;
    }

    public Vocabulary searchEnglishVocabulary(String nameEnglish) {

        Optional<Vocabulary> foundVocabulary = vocabularyRepo.findByNameEnglish(nameEnglish);
        if (foundVocabulary.isPresent()) {
            return foundVocabulary.get();
        } else {
            Vocabulary vocabularySearch = new Vocabulary(nameEnglish);
            vocabularySearch.setNameGerman(translateWord(nameEnglish));
//            vocabularySearch.setNameGerman("Wort Deutsch");
            try {
                vocabularyRepo.save(vocabularySearch);
            } catch (Exception exc) {
                System.out.println("Vocable nicht gespeichert");
            }
            return vocabularySearch;
        }
    }

    public Vocabulary searchEnglish(VocabularyRequest vocabularyRequest) {

        if(vocabularyRequest.getNameEnglish().isEmpty()) {
            throw new IllegalStateException("Die Eingabe von Deutsch->Englisch ist noch nicht möglich. Wir arbeiten daran. Bitte englisches Wort eingeben");
        }
        String nameEnglish = vocabularyRequest.getNameEnglish();
        return searchEnglishVocabulary(nameEnglish.toLowerCase());

    }

    public String translateWord(String nameEnglish) {
        try {
            URL url = new URL("https://api-free.deepl.com/v2/translate?auth_key=TOKEN&text="
                    + nameEnglish + "&target_lang=de&source_lang=en");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            String jsonString = content.toString();
            JSONObject obj = new JSONObject(jsonString);
            String nameGerman = "";
            JSONArray arr = obj.getJSONArray("translations");
            for (int i = 0; i < arr.length(); i++) {
                nameGerman = arr.getJSONObject(i).getString("text");
                if (nameGerman.isEmpty()) {
                    throw new IllegalStateException("Das Wort gibt es nicht!");
                }
            }
            in.close();
            con.disconnect();
            return nameGerman;
        } catch (IOException | JSONException exc) {
            exc.printStackTrace();
            System.out.println("Vokabel Abfrage extern fehlgeschlagen.");
        }
        return "Error";
    }

    public Vocabulary addVocabulary(VocabularyRequest vocabularyRequest) {
        Vocabulary newVocabulary = new Vocabulary(vocabularyRequest.getNameEnglish(), vocabularyRequest.getNameGerman());
        try {
            vocabularyRepo.save(newVocabulary);
        } catch (Exception exc) {
            //todo
        }
        return newVocabulary;
    }

    public List<Vocabulary> getVocabularyList() {
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
            try {
                vocabularyRepo.save(foundVocabulary);
            } catch (Exception exc) {
            }
            return foundVocabulary;
        }
        return null;
    }
}
