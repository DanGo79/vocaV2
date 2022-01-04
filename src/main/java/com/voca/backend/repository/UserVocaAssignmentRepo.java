package com.voca.backend.repository;

import com.voca.backend.Entity.UserVocaAssignment;
import com.voca.backend.Entity.Vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserVocaAssignmentRepo extends JpaRepository<UserVocaAssignment, Integer> {

    Optional<UserVocaAssignment> findDistinctByUserIdAndVocaId(Integer userId, Integer vocaId);

    List<UserVocaAssignment> findAllByUserIdAndLernenGelernt(Integer userId, Integer lernenGelernt);

//    @Query("SELECT voca_id FROM user_voca_assignment where user_id = '27' and lernen_gelernt = '1' ")
//    List<UserVocaAssignment> findUserVocaAssignmentByVocaId;
}