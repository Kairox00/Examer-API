package com.romeh.examer.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Exam {

  public Exam(String name) {
    this.name = name;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String name;

  @ManyToMany(mappedBy = "exams")
  private Set<Student> students = new HashSet<>();

  @OneToMany(mappedBy = "exam")
  private Set<Question> questions = new HashSet<>();

}
