package com.voca.backend.repository;

import com.voca.backend.Entity.UserVocaAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserVocaAssignmentRepo extends JpaRepository<UserVocaAssignment, Integer> {

  Optional<UserVocaAssignment> findDistinctByUserIdAndVocaId(Integer userId,Integer vocaId);

   Optional<UserVocaAssignment> findDistinctByUserIdAndLernenGelernt(Integer userId, Integer lernenGelernt);

//    @Query ("SELECT userId from ")

}
