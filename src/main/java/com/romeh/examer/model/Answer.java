package com.romeh.examer.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Answer {
  @EmbeddedId
  private AnswerId id;

  @ManyToOne
  @MapsId("studentId")
  @JoinColumn(name = "student_id")
  private Student student;

  @ManyToOne
  @MapsId("examId")
  @JoinColumn(name = "exam_id")
  private Exam exam;

  @ManyToOne
  @MapsId("questionId")
  @JoinColumn(name = "question_id")
  private Question question;

  @ManyToOne
  private Choice choice;

  public Answer(Exam exam, Student student, Question question, Choice choice) {
    this.id = new AnswerId(exam.getId(), student.getId(), question.getId());
    this.student = student;
    this.exam = exam;
    this.question = question;
    this.choice = choice;
  }
}
