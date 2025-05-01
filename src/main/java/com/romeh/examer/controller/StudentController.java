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

import com.romeh.examer.dto.StudentDTO;
import com.romeh.examer.model.Student;
import com.romeh.examer.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("")
  public List<StudentDTO> getAllStudents() {
    List<Student> students = studentService.getAllStudents();
    List<StudentDTO> studentsDTO = StudentDTO.fromStudentList(students);
    return studentsDTO;
  }

  @PostMapping("")
  public ResponseEntity<Void> createStudent(@RequestBody StudentDTO body) {
    Student newStudent = studentService.createStudent(body.getName());
    String location = "/students/" + newStudent.getId();
    return ResponseEntity.created(URI.create(location)).build();
  }

  @GetMapping("/{id}")
  public StudentDTO getMethodName(@PathVariable UUID id) {
    Student student = studentService.getStudent(id);
    StudentDTO studentDTO = StudentDTO.fromStudent(student);
    return studentDTO;
  }

}
