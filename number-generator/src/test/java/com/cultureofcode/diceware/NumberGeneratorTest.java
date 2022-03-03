package com.cultureofcode.diceware;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

// TODO better test method names
public class NumberGeneratorTest {

  private int min = 11111;
  private int max = 66666;

  @Test
  public void generate() {

    NumberGenerator numberGenerator = new NumberGenerator();

    for (int i = 0; i < 10000; i++) {
      Integer diceNum = numberGenerator.generate();
      assertThat(diceNum).as("Generated num greater than or equal to 11111").isGreaterThanOrEqualTo(min);
      assertThat(diceNum).as("Generated num less than or equal to 66666").isLessThanOrEqualTo(max);
    }
  }

  @Test
  public void generateValid() {
    NumberGenerator numberGenerator = new NumberGenerator();

    for (int i = 0; i < 10000; i++) {
      Integer diceNum = numberGenerator.generate();
      String s = String.valueOf(diceNum);
      s.chars().filter(digit -> digit == '0' || digit > '6')
          .forEach(digit -> fail("Generated bogus number " + diceNum));
    }
  }

  @Test
  public void generateSet() {

    NumberGenerator numberGenerator = new NumberGenerator();

    int[] setSize = {5, 6, 7, 8, 9, 10};
    Arrays.stream(setSize).forEach(i -> {
      assertThat(numberGenerator.generate(i).size()).as("Check size of generated number").isEqualTo(i);
    });
  }

  public void generateSetTooBig() {

    NumberGenerator numberGenerator = new NumberGenerator();
    // can you imagine?
    assertThatExceptionOfType(IllegalArgumentException.class)
    .isThrownBy(() -> numberGenerator.generate(55556));
  }

  public void generateSetTooSmall() {

    NumberGenerator numberGenerator = new NumberGenerator();
    // generator pleaze...
    assertThatExceptionOfType(IllegalArgumentException.class)
      .isThrownBy(() -> numberGenerator.generate(1));
  }

  @Test
  public void throwDice() {

    NumberGenerator numberGenerator = new NumberGenerator();

    for (int i = 0; i < 10000; i++) {
      int diceNum = numberGenerator.throwDice();
      if (diceNum < 1 || diceNum > 6) {
        fail("Dice throw is out of range " + diceNum);
      }
    }
  }

}
