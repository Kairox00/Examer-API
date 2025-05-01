package com.romeh.examer.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.romeh.examer.model.Question;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QuestionDTO {
  private UUID id;
  private String text;
  private int score;
  private List<ChoiceDTO> choices;

  public QuestionDTO(Question question) {
    this.id = question.getId();
    this.text = question.getText();
    this.score = question.getScore();
    this.choices = ChoiceDTO.fromChoiceList(question.getChoices());
  }

  public static List<QuestionDTO> fromQuestionList(List<Question> questions) {
    List<QuestionDTO> questionsDTO = new ArrayList<>();
    for (Question question : questions) {
      questionsDTO.add(new QuestionDTO(question));
    }
    return questionsDTO;
  }
}
