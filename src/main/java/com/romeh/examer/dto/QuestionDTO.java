package com.romeh.examer.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
    Set<Choice> choicesSet = question.getChoices();
    List<Choice> choicesList = new ArrayList<>(choicesSet);
    questionDTO.setChoices(ChoiceDTO.fromChoiceList(choicesList));
    return questionDTO;
  }

  public static List<QuestionDTO> fromQuestionList(List<Question> questions) {
    return questions.stream().map(QuestionDTO::fromQuestion).toList();
  }
}
