package com.romeh.examer.model;

import java.util.List;
import java.util.UUID;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Student {

  public Student(String name) {
    this.name = name;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NonNull
  private String name;

  @ManyToMany
  @JoinTable(name = "exam_attempt", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "exam_id"))
  private List<Exam> exams;

}
