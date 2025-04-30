package com.romeh.examer.dto;

import java.util.List;
import java.util.UUID;

import com.romeh.examer.model.Choice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChoiceDTO {
  private UUID id;
  private String text;
  private Boolean isCorrect;

  public static ChoiceDTO fromChoice(Choice choice) {
    ChoiceDTO choiceDTO = new ChoiceDTO();
    choiceDTO.setId(choice.getId());
    choiceDTO.setText(choice.getText());
    choiceDTO.setIsCorrect(choice.getIsCorrect());
    return choiceDTO;
  }

  public static List<ChoiceDTO> fromChoiceList(List<Choice> choices) {
    return choices.stream().map(ChoiceDTO::fromChoice).toList();
  }

}
