package com.romeh.examer.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.romeh.examer.model.Exam;
import com.romeh.examer.model.Student;
import com.romeh.examer.model.StudentExam;
import com.romeh.examer.repository.ExamRepository;
import com.romeh.examer.repository.StudentExamRepository;
import com.romeh.examer.repository.StudentRepository;

@Service
public class StudentExamService {
  private final StudentExamRepository studentExamRepository;
  private final ExamRepository examRepository;
  private final StudentRepository studentRepository;

  public StudentExamService(StudentExamRepository studentExamRepository, ExamRepository examRepository,
      StudentRepository studentRepository) {
    this.studentExamRepository = studentExamRepository;
    this.examRepository = examRepository;
    this.studentRepository = studentRepository;
  }

  public StudentExam createStudentExam(UUID studentId, UUID examId) {
    Student student = studentRepository.findById(studentId).orElseThrow();
    Exam exam = examRepository.findById(examId).orElseThrow();
    StudentExam newStudentExam = new StudentExam(student, exam);
    studentExamRepository.save(newStudentExam);
    return newStudentExam;
  }
}
