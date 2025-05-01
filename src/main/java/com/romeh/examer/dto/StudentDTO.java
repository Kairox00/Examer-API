package com.romeh.examer.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.romeh.examer.model.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
  private UUID id;
  private String name;
  private List<UUID> exams = new ArrayList<>();

  public StudentDTO(UUID id, String name) {
    this.id = id;
    this.name = name;
  }

  public static StudentDTO fromStudent(Student student) {
    return new StudentDTO(student.getId(), student.getName());
  }

  public static List<StudentDTO> fromStudentList(List<Student> students) {
    return students.stream().map(StudentDTO::fromStudent).toList();
  }
}
