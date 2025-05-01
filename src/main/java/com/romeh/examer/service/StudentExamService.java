package com.romeh.examer.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.romeh.examer.model.Answer;
import com.romeh.examer.model.Choice;
import com.romeh.examer.model.Exam;
import com.romeh.examer.model.ExamAttempt;
import com.romeh.examer.model.ExamAttemptId;
import com.romeh.examer.model.Question;
import com.romeh.examer.model.Student;
import com.romeh.examer.repository.AnswerRepository;
import com.romeh.examer.repository.ExamRepository;
import com.romeh.examer.repository.StudentExamRepository;
import com.romeh.examer.repository.StudentRepository;

@Service
public class StudentExamService {
  private final StudentExamRepository studentExamRepository;
  private final ExamRepository examRepository;
  private final StudentRepository studentRepository;
  private final AnswerRepository answerRepository;

  public StudentExamService(StudentExamRepository studentExamRepository,
      ExamRepository examRepository, StudentRepository studentRepository,
      AnswerRepository answerRepository) {
    this.studentExamRepository = studentExamRepository;
    this.examRepository = examRepository;
    this.studentRepository = studentRepository;
    this.answerRepository = answerRepository;
  }

  public ExamAttempt createStudentExam(UUID studentId, UUID examId) {
    if (studentExamRepository.existsById(new ExamAttemptId(studentId, examId))) {
      throw new IllegalArgumentException("Student has already been assigned to this exam");
    }
    Student student = studentRepository.findById(studentId).orElseThrow();
    Exam exam = examRepository.findById(examId).orElseThrow();
    ExamAttempt newStudentExam = new ExamAttempt(student, exam);
    studentExamRepository.save(newStudentExam);
    return newStudentExam;
  }

  @Transactional
  public ExamAttempt submitExam(UUID studentId, UUID examId) {
    ExamAttempt studentExam = studentExamRepository.findById(new ExamAttemptId(studentId, examId)).orElseThrow();
    if (studentExam.getSubmittedAt() != null) {
      throw new IllegalArgumentException("Student has already submitted this exam");
    }
    List<Answer> answers = answerRepository.findAllByStudentIdAndExamId(studentId, examId);
    List<Choice> correctChoices = answers.stream().map(Answer::getChoice).filter(Choice::getIsCorrect).toList();
    int score = correctChoices.stream().map(Choice::getQuestion)
        .map(Question::getScore)
        .reduce(0, Integer::sum);
    studentExam.setScore(score);
    studentExam.setSubmittedAt(LocalDateTime.now());
    studentExamRepository.save(studentExam);
    return studentExam;
  }

  public List<Student> getAllExamStudents(UUID examId) {
    List<ExamAttempt> studentExams = studentExamRepository.findAllByExamId(examId);
    List<Student> students = studentExams.stream().map(ExamAttempt::getStudent).toList();
    return students;
  }
}
