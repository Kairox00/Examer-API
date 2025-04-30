package com.romeh.examer.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romeh.examer.dto.QuestionDTO;
import com.romeh.examer.model.Question;
import com.romeh.examer.service.QuestionService;

@RestController
@RequestMapping("/exams/{examId}/questions")
public class QuestionController {
  private final QuestionService questionService;

  public QuestionController(QuestionService questionService) {
    this.questionService = questionService;

  }

  @GetMapping("/")
  public List<QuestionDTO> getAllExamQuestions(@PathVariable UUID examId) {
    List<Question> questions = questionService.getAllQuestionsByExam(examId);
    List<QuestionDTO> questionsDTO = QuestionDTO.fromQuestionList(questions);
    return questionsDTO;
  }

  @PostMapping("/")
  public ResponseEntity<Void> addQuestion(@RequestBody QuestionDTO body, @PathVariable UUID examId) {
    Question question = questionService.createQuestion(examId, body.getText(), body.getScore(),
        body.getChoices());
    String location = "/exams/" + question.getExam().getId() + "/question/" + question.getId();
    return ResponseEntity.created(URI.create(location)).build();
  }

}
