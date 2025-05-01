package com.romeh.examer.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.romeh.examer.model.Student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentDTO {
  private UUID id;
  private String name;
  private List<ExamDTO> exams;

  public StudentDTO(UUID id) {
    this.id = id;
  }

  public StudentDTO(Student student) {
    this.id = student.getId();
    this.name = student.getName();
    this.exams = ExamDTO.fromExamList(student.getExams());
  }

  public static List<StudentDTO> fromStudentList(List<Student> students) {
    List<StudentDTO> studentsDTO = new ArrayList<>();
    for (Student student : students) {
      studentsDTO.add(new StudentDTO(student));
    }
    return studentsDTO;
  }
}
