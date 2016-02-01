package com.cultureofcode.diceware;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;

/**
 * A simple DTO for wrapping up Set of Diceware Numbers.
 *
 * @author kenneth
 */
public class DicewareNumbers {

  @JsonProperty("diceware_numbers")
  Set<Integer> dicewareNumbers;

  public Set<Integer> getDicewareNumbers() {
    return dicewareNumbers;
  }

  public DicewareNumbers setDicewareNumbers(Set<Integer> dicewareNumbers) {
    this.dicewareNumbers = dicewareNumbers;
    return this;
  }
}
