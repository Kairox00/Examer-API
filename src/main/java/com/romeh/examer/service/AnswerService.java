package com.romeh.examer.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.romeh.examer.model.Answer;
import com.romeh.examer.model.Choice;
import com.romeh.examer.model.Student;
import com.romeh.examer.repository.AnswerRepository;
import com.romeh.examer.repository.ChoiceRepository;
import com.romeh.examer.repository.StudentRepository;

@Service
public class AnswerService {
  private final AnswerRepository answerRepository;
  private final ChoiceRepository choiceRepository;
  private final StudentRepository studentRepository;

  public AnswerService(AnswerRepository answerRepository, ChoiceRepository choiceRepository,
      StudentRepository studentRepository) {
    this.answerRepository = answerRepository;
    this.choiceRepository = choiceRepository;
    this.studentRepository = studentRepository;
  };

  public Answer submitAnswer(UUID studentId, UUID choiceId) {
    Choice choice = choiceRepository.findById(choiceId).orElseThrow();
    Student student = studentRepository.findById(studentId).orElseThrow();
    Answer newAnswer = new Answer(choice.getQuestion().getExam(), student, choice.getQuestion(), choice);
    answerRepository.save(newAnswer);
    return newAnswer;
  };

  public List<Answer> getAllStudentAnswersForExam(UUID studentId, UUID examId) {
    return answerRepository.findAllByStudentIdAndExamId(studentId, examId);
  }
}
