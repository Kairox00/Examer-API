package com.romeh.examer.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.romeh.examer.model.ExamAttempt;

import lombok.Getter;

@Getter
public class ExamAttemptDTO {
  private UUID studentId;
  private UUID examId;
  private LocalDateTime startedAt;
  private LocalDateTime submittedAt;

  public ExamAttemptDTO(ExamAttempt studentExam) {
    this.studentId = studentExam.getStudent().getId();
    this.examId = studentExam.getExam().getId();
    this.startedAt = studentExam.getStartedAt();
    this.submittedAt = studentExam.getSubmittedAt();
  }
}
