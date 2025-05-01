package com.romeh.examer.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.romeh.examer.model.Exam;
import com.romeh.examer.model.Student;
import com.romeh.examer.model.StudentExam;
import com.romeh.examer.model.StudentExamId;
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
    if (studentExamRepository.existsById(new StudentExamId(studentId, examId))) {
      throw new IllegalArgumentException("Student has already been assigned to this exam");
    }
    Student student = studentRepository.findById(studentId).orElseThrow();
    Exam exam = examRepository.findById(examId).orElseThrow();
    StudentExam newStudentExam = new StudentExam(student, exam);
    studentExamRepository.save(newStudentExam);
    return newStudentExam;
  }

  public StudentExam addSubmissionDate(UUID studentId, UUID examId) {
    StudentExam studentExam = studentExamRepository.findById(new StudentExamId(studentId, examId)).orElseThrow();
    if (studentExam.getSubmittedAt() != null) {
      throw new IllegalArgumentException("Student has already submitted this exam");
    }
    studentExam.setSubmittedAt(LocalDateTime.now());
    studentExamRepository.save(studentExam);
    return studentExam;
  }

  public List<Student> getAllExamStudents(UUID examId) {
    List<StudentExam> studentExams = studentExamRepository.findAllByExamId(examId);
    List<Student> students = studentExams.stream().map(StudentExam::getStudent).toList();
    return students;
  }
}
