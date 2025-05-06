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
import com.romeh.examer.repository.ExamAttemptRepository;
import com.romeh.examer.repository.ExamRepository;
import com.romeh.examer.repository.StudentRepository;

@Service
public class ExamAttemptService {
  private final ExamAttemptRepository examAttemptRepository;
  private final ExamRepository examRepository;
  private final StudentRepository studentRepository;
  private final AnswerRepository answerRepository;

  public ExamAttemptService(ExamAttemptRepository examAttemptRepository,
      ExamRepository examRepository, StudentRepository studentRepository,
      AnswerRepository answerRepository) {
    this.examAttemptRepository = examAttemptRepository;
    this.examRepository = examRepository;
    this.studentRepository = studentRepository;
    this.answerRepository = answerRepository;
  }

  public ExamAttempt createExamAttempt(UUID studentId, UUID examId) {
    ExamAttempt existingAttempt = examAttemptRepository.findById(new ExamAttemptId(studentId, examId)).orElse(null);
    if (existingAttempt.getSubmittedAt() != null) {
      throw new IllegalArgumentException("Student has already finished  this exam");
    }
    Student student = studentRepository.findById(studentId).orElseThrow();
    Exam exam = examRepository.findById(examId).orElseThrow();
    ExamAttempt newStudentExam = new ExamAttempt(student, exam);
    examAttemptRepository.save(newStudentExam);
    return newStudentExam;
  }

  public ExamAttempt startExam(UUID studentId, UUID examId) {
    ExamAttempt existingAttempt = examAttemptRepository.findById(new ExamAttemptId(studentId, examId)).orElseThrow();
    if (existingAttempt.getStartedAt() == null) {
      existingAttempt.setStartedAt(LocalDateTime.now());
      examAttemptRepository.save(existingAttempt);
    }
    return existingAttempt;
  }

  @Transactional
  public ExamAttempt submitExam(UUID studentId, UUID examId) {
    ExamAttempt studentExam = examAttemptRepository.findById(new ExamAttemptId(studentId, examId)).orElseThrow();
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
    examAttemptRepository.save(studentExam);
    return studentExam;
  }

  public List<Student> getAllExamStudents(UUID examId) {
    List<ExamAttempt> studentExams = examAttemptRepository.findAllByExamId(examId);
    List<Student> students = studentExams.stream().map(ExamAttempt::getStudent).toList();
    return students;
  }

  public ExamAttempt getExamAttempt(UUID studentId, UUID examId) {
    return examAttemptRepository.findById(new ExamAttemptId(studentId, examId)).orElseThrow();
  }
}
