package com.romeh.examer.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exam_attempt")
@NoArgsConstructor
@Data
public class ExamAttempt {
  @EmbeddedId
  private ExamAttemptId id;

  @ManyToOne
  @MapsId("studentId")
  @JoinColumn(name = "student_id")
  private Student student;

  @ManyToOne
  @MapsId("examId")
  @JoinColumn(name = "exam_id")
  private Exam exam;

  @CreationTimestamp
  @Column(name = "started_at", nullable = true, updatable = false)
  private LocalDateTime startedAt;

  @Nullable
  private LocalDateTime submittedAt;

  @Nullable
  private int score;

  public ExamAttempt(Student student, Exam exam) {
    this.id = new ExamAttemptId(student.getId(), exam.getId());
    this.student = student;
    this.exam = exam;
    this.score = 0;
  }
}
