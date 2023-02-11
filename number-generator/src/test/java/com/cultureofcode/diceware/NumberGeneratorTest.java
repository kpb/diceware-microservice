package com.cultureofcode.diceware;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {

  // class under test
  NumberGenerator numberGenerator;

  private int min = 11111;
  private int max = 66666;

  @BeforeEach
  void beforeEach() {
    numberGenerator = new NumberGenerator();
  }

  @Test
  public void generate_10kNumbers_betweenMinandMax() {

    for (int i = 0; i < 10000; i++) {
      Integer diceNum = numberGenerator.generate();
      assertThat(diceNum).as("Generated num greater than or equal to 11111")
          .isGreaterThanOrEqualTo(min);
      assertThat(diceNum).as("Generated num less than or equal to 66666").isLessThanOrEqualTo(max);
    }
  }

  @Test
  public void generate_10kNumbers_validDiceNumbers() {

    for (int i = 0; i < 10000; i++) {
      Integer diceNum = numberGenerator.generate();
      String s = String.valueOf(diceNum);
      s.chars().filter(digit -> digit == '0' || digit > '6')
          .forEach(digit -> fail("Generated bogus number " + diceNum));
    }
  }

  @Test
  public void generate_setsOfNumbers_correctSize() {

    int[] setSize = {5, 6, 7, 8, 9, 10};
    Arrays.stream(setSize).forEach(i -> {
      assertThat(numberGenerator.generate(i).size()).as("Check size of generated number")
          .isEqualTo(i);
    });
  }

  public void generate_ridiculousNumber_throwsIllegalArgException() {

    // can you imagine?
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> numberGenerator.generate(55556));
  }

  public void generate_toFewNumbers_throwsIllegalArgException() {

    // generator pleaze...
    assertThatExceptionOfType(IllegalArgumentException.class)
        .as("It doesn't make sense to generate fewer than 3 numbers")
        .isThrownBy(() -> numberGenerator.generate(1));
  }

  @Test
  public void throwDice_100kTimes_alwaysBetween1and6() {

    for (int i = 0; i < 100000; i++) {
      int diceNum = numberGenerator.throwDice();
      assertThat(diceNum).isBetween(1, 6);
    }
  }
}
