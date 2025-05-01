package com.romeh.examer.dto;

import java.util.UUID;

import com.romeh.examer.model.Exam;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExamDTO {
  private UUID id;
  private String name;

  public ExamDTO(Exam exam) {
    this.id = exam.getId();
    this.name = exam.getName();
  }
}
