package com.romeh.examer.model;

import java.util.List;
import java.util.UUID;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

  @NonNull
  private String name;

  @ManyToMany(mappedBy = "exams", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Student> students;

  @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Question> questions;

  @NonNull
  private int duration;

}
