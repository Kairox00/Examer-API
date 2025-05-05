package com.romeh.examer.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.romeh.examer.model.ExamAttempt;
import com.romeh.examer.model.ExamAttemptId;

public interface ExamAttemptRepository extends JpaRepository<ExamAttempt, ExamAttemptId> {
  public List<ExamAttempt> findAllByExamId(UUID examId);
}
