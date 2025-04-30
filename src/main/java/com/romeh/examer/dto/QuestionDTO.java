package com.romeh.examer.dto;

import java.util.List;
import java.util.UUID;

import com.romeh.examer.model.Choice;
import com.romeh.examer.model.Question;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDTO {
  private UUID id;
  private String text;
  private int score;
  private List<ChoiceDTO> choices;

  public static QuestionDTO fromQuestion(Question question) {
    QuestionDTO questionDTO = new QuestionDTO();
    questionDTO.setText(question.getText());
    questionDTO.setScore(question.getScore());
    questionDTO.setId(question.getId());
    List<Choice> choices = question.getChoices();
    questionDTO.setChoices(ChoiceDTO.fromChoiceList(choices));
    return questionDTO;
  }

  public static List<QuestionDTO> fromQuestionList(List<Question> questions) {
    return questions.stream().map(QuestionDTO::fromQuestion).toList();
  }
}
