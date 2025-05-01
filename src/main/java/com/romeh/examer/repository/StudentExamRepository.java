package com.romeh.examer.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.romeh.examer.model.StudentExam;
import com.romeh.examer.model.StudentExamId;

public interface StudentExamRepository extends JpaRepository<StudentExam, StudentExamId> {
  public List<StudentExam> findAllByExamId(UUID examId);
}
