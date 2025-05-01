package com.romeh.examer.controller;

import java.net.URI;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romeh.examer.dto.StudentDTO;
import com.romeh.examer.model.StudentExam;
import com.romeh.examer.service.StudentExamService;

@RestController
@RequestMapping("/exams/{examId}/students")
public class StudentExamController {
  private final StudentExamService studentExamService;

  public StudentExamController(StudentExamService studentExamService) {
    this.studentExamService = studentExamService;
  }

  @PostMapping("")
  public ResponseEntity<Void> createExamForStudent(@RequestBody StudentDTO studentDTO, @PathVariable UUID examId) {
    StudentExam studentExam = studentExamService.createStudentExam(studentDTO.getId(), examId);
    String location = "/exams/" + studentExam.getExam().getId() + "/students/" + studentExam.getStudent().getId();
    return ResponseEntity.created(URI.create(location)).build();
  }

  @PutMapping("path/{id}")
  public String putMethodName(@PathVariable String id, @RequestBody String entity) {
    // TODO: process PUT request

    return entity;
  }

}
