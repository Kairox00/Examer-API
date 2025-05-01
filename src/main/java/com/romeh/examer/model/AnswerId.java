package com.romeh.examer.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class AnswerId {
  @Column(name = "student_id")
  private UUID studentId;

  @Column(name = "exam_id")
  private UUID examId;

  @Column(name = "question_id")
  private UUID questionId;

  public AnswerId(UUID studentId, UUID examId, UUID questionId) {
    this.studentId = studentId;
    this.examId = examId;
    this.questionId = questionId;
  }
}
