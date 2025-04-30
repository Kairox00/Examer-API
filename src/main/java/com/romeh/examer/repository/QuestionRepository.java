package com.romeh.examer.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romeh.examer.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, UUID> {
  public List<Question> findAllByExamId(UUID id);
}
