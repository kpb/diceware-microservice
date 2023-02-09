package com.cultureofcode.diceware;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;

/**
 * A simple DTO for wrapping up Set of Diceware Numbers.
 *
 * @author kenneth
 */
record DicewareNumbers(@JsonProperty("diceware_numbers") Set<Integer> dicewareNumbers) {
}
