package com.romeh.examer.dto;

import java.util.List;
import java.util.UUID;

import com.romeh.examer.model.Exam;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExamDTO {
  private UUID id;
  private String name;
  private int duration;
  private int numberOfQuestions;

  public ExamDTO(Exam exam) {
    this.id = exam.getId();
    this.name = exam.getName();
    this.duration = exam.getDuration();
    this.numberOfQuestions = exam.getQuestions().size();
  }

  public static List<ExamDTO> fromExamList(List<Exam> exams) {
    return exams.stream().map(ExamDTO::new).toList();
  }
}
