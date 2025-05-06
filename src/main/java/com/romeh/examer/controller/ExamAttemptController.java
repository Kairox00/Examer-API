package com.romeh.examer.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romeh.examer.dto.ExamAttemptDTO;
import com.romeh.examer.dto.StudentDTO;
import com.romeh.examer.model.ExamAttempt;
import com.romeh.examer.model.Student;
import com.romeh.examer.service.ExamAttemptService;

@RestController
@RequestMapping("/exams/{examId}/students")
public class ExamAttemptController {

  private final ExamAttemptService examAttemptService;

  public ExamAttemptController(ExamAttemptService studentExamService) {
    this.examAttemptService = studentExamService;
  }

  @GetMapping("")
  public List<StudentDTO> getAllExamStudents(@PathVariable UUID examId) {
    List<Student> students = examAttemptService.getAllExamStudents(examId);
    List<StudentDTO> studentsDTO = StudentDTO.fromStudentList(students);
    return studentsDTO;
  }

  @PostMapping("")
  public ResponseEntity<Void> createExamAttempt(@RequestBody StudentDTO studentDTO, @PathVariable UUID examId) {
    ExamAttempt studentExam = examAttemptService.createExamAttempt(studentDTO.getId(), examId);
    String location = "/exams/" + studentExam.getExam().getId() + "/students/" + studentExam.getStudent().getId();
    return ResponseEntity.created(URI.create(location)).build();
  }

  @GetMapping("/{studentId}")
  public ResponseEntity<ExamAttemptDTO> getExamAttemptForStudent(@PathVariable UUID studentId,
      @PathVariable UUID examId) {
    ExamAttempt attempt = examAttemptService.getExamAttempt(studentId, examId);
    ExamAttemptDTO attemptDTO = new ExamAttemptDTO(attempt);
    return ResponseEntity.ok().body(attemptDTO);
  }

  @PutMapping("/{studentId}/start")
  public ResponseEntity<ExamAttemptDTO> startExam(@PathVariable UUID studentId, @PathVariable UUID examId) {
    ExamAttempt studentExam = examAttemptService.startExam(studentId, examId);
    ExamAttemptDTO studentExamDTO = new ExamAttemptDTO(studentExam);
    return ResponseEntity.ok().body(studentExamDTO);
  }

  @PutMapping("/{studentId}/submit")
  public ResponseEntity<ExamAttemptDTO> submitExam(@PathVariable UUID studentId, @PathVariable UUID examId) {
    ExamAttempt studentExam = examAttemptService.submitExam(studentId, examId);
    ExamAttemptDTO studentExamDTO = new ExamAttemptDTO(studentExam);
    return ResponseEntity.ok().body(studentExamDTO);
  }

}
