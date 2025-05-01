package com.romeh.examer.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class StudentExamId implements Serializable {
  @Column(name = "student_id")
  private UUID studentId;

  @Column(name = "exam_id")
  private UUID examId;

  public StudentExamId(UUID studentId, UUID examId) {
    this.studentId = studentId;
    this.examId = examId;
  }
}
