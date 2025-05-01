package com.romeh.examer.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.romeh.examer.model.Student;
import com.romeh.examer.repository.StudentRepository;

@Service
public class StudentService {
  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public Student createStudent(String name) {
    Student newStudent = new Student(name);
    studentRepository.save(newStudent);
    return newStudent;
  }

  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  public Student getStudent(UUID id) {
    return studentRepository.findById(id).orElseThrow();
  }
}
