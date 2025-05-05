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

import com.romeh.examer.dto.ExamDTO;
import com.romeh.examer.model.Exam;
import com.romeh.examer.service.ExamService;

@RestController
@RequestMapping("/exams")
public class ExamController {
  private final ExamService examService;

  public ExamController(ExamService examService) {
    this.examService = examService;
  }

  @GetMapping("")
  public List<ExamDTO> getExams() {
    return ExamDTO.fromExamList(examService.getAllExams());
  }

  @PostMapping("")
  public ResponseEntity<Void> createExam(@RequestBody ExamDTO examDTO) {
    Exam exam = examService.createExam(examDTO.getName());
    String location = "/exams/" + exam.getId();
    return ResponseEntity.created(URI.create(location)).build();
  }

  @GetMapping("/{id}")
  public Exam getExam(@PathVariable UUID id) {
    return examService.getExam(id);
  }

}
