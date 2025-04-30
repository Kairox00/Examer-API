package com.romeh.examer.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.romeh.examer.dto.ChoiceDTO;
import com.romeh.examer.model.Choice;
import com.romeh.examer.model.Exam;
import com.romeh.examer.model.Question;
import com.romeh.examer.repository.ChoiceRepository;
import com.romeh.examer.repository.ExamRepository;
import com.romeh.examer.repository.QuestionRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

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

  @Transactional
  public Question createQuestion(UUID examId, String text, int score, List<ChoiceDTO> choicesDTO) {
    Exam exam = examRepository.findById(examId)
        .orElseThrow(() -> new EntityNotFoundException("Exam not found with ID: " + examId));
    Question newQuestion = new Question(text, score, exam);
    questionRepository.save(newQuestion);
    List<Choice> choices = choicesDTO.stream()
        .map(dto -> new Choice(dto.getText(), dto.getIsCorrect(), newQuestion))
        .collect(Collectors.toList());
    choiceRepository.saveAll(choices);
    return newQuestion;
  }

  public List<Question> getAllQuestionsByExam(UUID examId) {
    Exam exam = examRepository.findById(examId).orElseThrow();
    return exam.getQuestions();
  }
}
