package com.voca.backend.repository;

import com.voca.backend.Entity.User;
import com.voca.backend.Entity.UserVocaAssignment;
import com.voca.backend.Entity.Vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserVocaAssignmentRepo extends JpaRepository<UserVocaAssignment, Integer> {

//    @Modifying
//    @Query("DELETE FROM UserVocaAssignment AS u WHERE u.user.id=:userId AND u.id.vocaId=:vocaId")
//    void deV(@Param("userId") Integer userId, @Param("vocaId") Integer vocaId);


    Optional<UserVocaAssignment> findDistinctByUserAndVocabularyAndLernenGelernt(User user, Vocabulary vocabulary, Integer lernenGelernt);

    Optional<UserVocaAssignment> findDistinctByUserAndVocabulary(User user, Vocabulary vocabulary);

    @Query("SELECT a.vocabulary FROM UserVocaAssignment a where a.user = ?1 and a.lernenGelernt = ?2 ")
    List<Vocabulary> findAllByUserAndLernenGelernt(User user, Integer lernenGelernt);

//    @Query(value = "SELECT b.nameEnglish, b.nameGerman FROM UserVocaAssignment a inner join Vocabulary b on a.vocaId = b.vocaId where a.userId = ?1 and a.lernenGelernt = ?2 ")
//    List<Object> findAllByUserIdAndLernenGelernt(Integer userId, boolean lernenGelernt);

}
//SELECT *
//        FROM user_voca_assignmena
//        inner join vocabularies on user_voca_assignment.voca_id = vocabularies.vocaId
//        where user_id = '27' and lernen_gelernt = '1';