package com.romeh.examer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.romeh.examer.model.StudentExam;
import com.romeh.examer.model.StudentExamId;

public interface StudentExamRepository extends JpaRepository<StudentExam, StudentExamId> {

}
