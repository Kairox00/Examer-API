package com.romeh.examer.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Choice {

  public Choice(String text, Boolean isCorrect, Question question) {
    this.text = text;
    this.isCorrect = isCorrect;
    this.question = question;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String text;

  private Boolean isCorrect;

  @ManyToOne
  @JoinColumn(name = "question_id")
  private Question question;

}
