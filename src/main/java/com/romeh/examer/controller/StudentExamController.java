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

import com.romeh.examer.dto.StudentDTO;
import com.romeh.examer.dto.StudentExamDTO;
import com.romeh.examer.model.Student;
import com.romeh.examer.model.StudentExam;
import com.romeh.examer.service.StudentExamService;

@RestController
@RequestMapping("/exams/{examId}/students")
public class StudentExamController {
  private final StudentExamService studentExamService;

  public StudentExamController(StudentExamService studentExamService) {
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
    StudentExam studentExam = studentExamService.createStudentExam(studentDTO.getId(), examId);
    String location = "/exams/" + studentExam.getExam().getId() + "/students/" + studentExam.getStudent().getId();
    return ResponseEntity.created(URI.create(location)).build();
  }

  @PatchMapping("/{studentId}")
  public ResponseEntity<StudentExamDTO> submitExam(@PathVariable UUID studentId, @PathVariable UUID examId) {
    StudentExam studentExam = studentExamService.submitExam(studentId, examId);
    StudentExamDTO studentExamDTO = new StudentExamDTO(studentExam);
    return ResponseEntity.ok().body(studentExamDTO);
  }

}
