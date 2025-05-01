package com.romeh.examer.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romeh.examer.dto.ExamAttemptDTO;
import com.romeh.examer.dto.StudentDTO;
import com.romeh.examer.model.ExamAttempt;
import com.romeh.examer.model.Student;
import com.romeh.examer.service.StudentExamService;

@RestController
@RequestMapping("/exams/{examId}/students")
public class ExamAttemptController {
  private final StudentExamService studentExamService;

  public ExamAttemptController(StudentExamService studentExamService) {
    this.studentExamService = studentExamService;
  }

  @GetMapping("")
  public List<StudentDTO> getAllExamStudents(@PathVariable UUID examId) {
    List<Student> students = studentExamService.getAllExamStudents(examId);
    List<StudentDTO> studentsDTO = StudentDTO.fromStudentList(students);
    return studentsDTO;
  }

  @PostMapping("")
  public ResponseEntity<Void> startExamForStudent(@RequestBody StudentDTO studentDTO, @PathVariable UUID examId) {
    ExamAttempt studentExam = studentExamService.createStudentExam(studentDTO.getId(), examId);
    String location = "/exams/" + studentExam.getExam().getId() + "/students/" + studentExam.getStudent().getId();
    return ResponseEntity.created(URI.create(location)).build();
  }

  @PatchMapping("/{studentId}")
  public ResponseEntity<ExamAttemptDTO> submitExam(@PathVariable UUID studentId, @PathVariable UUID examId) {
    ExamAttempt studentExam = studentExamService.submitExam(studentId, examId);
    ExamAttemptDTO studentExamDTO = new ExamAttemptDTO(studentExam);
    return ResponseEntity.ok().body(studentExamDTO);
  }

}
