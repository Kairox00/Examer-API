package com.romeh.examer.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name = "student_exam")
@NoArgsConstructor
@Data
public class StudentExam {
  @EmbeddedId
  private StudentExamId id;

  @ManyToOne
  @MapsId("studentId")
  @JoinColumn(name = "student_id")
  private Student student;

  @ManyToOne
  @MapsId("examId")
  @JoinColumn(name = "exam_id")
  private Exam exam;

  @CreationTimestamp
  @Column(name = "started_at", nullable = false, updatable = false)
  private LocalDateTime startedAt;

  private LocalDateTime submittedAt;

  private int score;

  public StudentExam(Student student, Exam exam) {
    this.id = new StudentExamId(student.getId(), exam.getId());
    this.student = student;
    this.exam = exam;
    this.score = 0;
  }
}
