package com.romeh.examer.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.romeh.examer.model.StudentExam;

import lombok.Getter;

@Getter
public class StudentExamDTO {
  private UUID studentId;
  private UUID examId;
  private LocalDateTime startedAt;
  private LocalDateTime submittedAt;

  public StudentExamDTO(StudentExam studentExam) {
    this.studentId = studentExam.getStudent().getId();
    this.examId = studentExam.getExam().getId();
    this.startedAt = studentExam.getStartedAt();
    this.submittedAt = studentExam.getSubmittedAt();
  }
}
