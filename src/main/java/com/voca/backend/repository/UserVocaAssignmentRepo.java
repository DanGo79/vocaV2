package com.voca.backend.repository;

import com.voca.backend.Entity.UserVocaAssignment;
import com.voca.backend.Entity.Vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserVocaAssignmentRepo extends JpaRepository<UserVocaAssignment, Integer> {

    Optional<UserVocaAssignment> findDistinctByUserAndVocabulary(Integer userId, Integer vocaId);


    //    @Query("SELECT a FROM UserVocaAssignment a where a.userId = ?1 and a.lernenGelernt = ?2 ")
    List<UserVocaAssignment> findAllByUserAndLernenGelernt(Integer userId, boolean lernenGelernt);

//    @Query(value = "SELECT b.nameEnglish, b.nameGerman FROM UserVocaAssignment a inner join Vocabulary b on a.vocaId = b.vocaId where a.userId = ?1 and a.lernenGelernt = ?2 ")
//    List<Object> findAllByUserIdAndLernenGelernt(Integer userId, boolean lernenGelernt);

}
//SELECT *
//        FROM user_voca_assignmena
//        inner join vocabularies on user_voca_assignment.voca_id = vocabularies.vocaId
//        where user_id = '27' and lernen_gelernt = '1';