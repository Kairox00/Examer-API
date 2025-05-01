package com.romeh.examer.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.romeh.examer.model.Answer;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnswerDTO {
  private UUID questionId;
  private ChoiceDTO choice;

  public AnswerDTO(Answer answer) {
    this.questionId = answer.getQuestion().getId();
    this.choice = new ChoiceDTO(answer.getChoice());
  }

  public static List<AnswerDTO> fromAnswerList(List<Answer> answers) {
    List<AnswerDTO> answersDTO = new ArrayList<>();
    for (Answer answer : answers) {
      answersDTO.add(new AnswerDTO(answer));
    }
    return answersDTO;
  }
}
