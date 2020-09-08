package com.cultureofcode.diceware.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;

/**
 * DTO binding to the diceware-number-service return.
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

    @Override
    public String toString() {
        return "DicewareNumbers{" + "dicewareNumbers=" + dicewareNumbers + '}';
    }
}
