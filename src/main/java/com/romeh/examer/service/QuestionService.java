package com.romeh.examer.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.romeh.examer.dto.ChoiceDTO;
import com.romeh.examer.model.Choice;
import com.romeh.examer.model.Exam;
import com.romeh.examer.model.Question;
import com.romeh.examer.repository.ChoiceRepository;
import com.romeh.examer.repository.ExamRepository;
import com.romeh.examer.repository.QuestionRepository;

@Service
public class QuestionService {
  private final QuestionRepository questionRepository;
  private final ExamRepository examRepository;
  private final ChoiceRepository choiceRepository;

  public QuestionService(QuestionRepository questionRepository, ExamRepository examRepository,
      ChoiceRepository choiceRepository) {
    this.questionRepository = questionRepository;
    this.examRepository = examRepository;
    this.choiceRepository = choiceRepository;
  }

  public Question createQuestion(UUID examId, String text, int score, List<ChoiceDTO> choicesDTO) {
    Exam exam = examRepository.findById(examId).orElseThrow();
    Question newQuestion = new Question(text, score, exam);
    questionRepository.save(newQuestion);
    Set<Choice> newChoices = new HashSet<Choice>();
    for (ChoiceDTO choice : choicesDTO) {
      Choice newChoice = new Choice(choice.getText(), choice.getIsCorrect(), newQuestion);
      choiceRepository.save(newChoice);
      newChoices.add(newChoice);
    }
    newQuestion.setChoices(newChoices);
    questionRepository.save(newQuestion);
    exam.getQuestions().add(newQuestion);
    examRepository.save(exam);
    return newQuestion;
  }

  public List<Question> getAllQuestionsByExam(UUID examId) {
    List<Question> questions = questionRepository.findAllByExamId(examId);
    return questions;
  }
}
