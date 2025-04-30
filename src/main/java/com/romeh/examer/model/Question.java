package com.romeh.examer.model;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Question {

  public Question(String text, int score, Exam exam) {
    this.text = text;
    this.score = score;
    this.exam = exam;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String text;

  private int score;

  @ManyToOne
  @JoinColumn(name = "exam_id")
  private Exam exam;

  @OneToMany(mappedBy = "question")
  private Set<Choice> choices;
}
