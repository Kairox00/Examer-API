package com.romeh.examer.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.romeh.examer.model.Choice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChoiceDTO {
  private UUID id;
  private String text;
  private Boolean isCorrect;

  public ChoiceDTO(Choice choice) {
    this.id = choice.getId();
    this.text = choice.getText();
    this.isCorrect = choice.getIsCorrect();
  }

  public static List<ChoiceDTO> fromChoiceList(List<Choice> choices) {
    List<ChoiceDTO> choicesDTO = new ArrayList<>();
    for (Choice choice : choices) {
      choicesDTO.add(new ChoiceDTO(choice));
    }
    return choicesDTO;
  }

}
