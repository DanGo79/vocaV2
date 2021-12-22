package com.voca.backend.repository;


import com.voca.backend.Entity.Vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VocabularyRepo extends JpaRepository<Vocabulary, Integer> {

    Optional<Vocabulary> findByNameEnglish(String nameEnglish);

    Optional<Vocabulary> findByNameGerman(String nameGerman);


}



