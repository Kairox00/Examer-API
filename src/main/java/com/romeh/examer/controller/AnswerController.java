package com.romeh.examer.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romeh.examer.dto.AnswerDTO;
import com.romeh.examer.model.Answer;
import com.romeh.examer.service.AnswerService;

@RestController
@RequestMapping("/exams/{examId}/students/{studentId}/answers")
public class AnswerController {
  private final AnswerService answerService;

  public AnswerController(AnswerService answerService) {
    this.answerService = answerService;
  }

  @GetMapping("")
  public List<AnswerDTO> getAllStudentAnswersForExam(@PathVariable UUID examId,
      @PathVariable UUID studentId) {
    List<Answer> answers = answerService.getAllStudentAnswersForExam(studentId, examId);
    List<AnswerDTO> answersDTO = AnswerDTO.fromAnswerList(answers);
    return answersDTO;
  }

  @PostMapping("")
  public ResponseEntity<Void> submitAnswer(@RequestBody AnswerDTO body,
      @PathVariable UUID studentId, @PathVariable UUID examId) {
    Answer answer = answerService.submitAnswer(studentId, examId, body.getChoice().getId());
    return ResponseEntity.created(null).build();
  }

}
