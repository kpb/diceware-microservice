package com.cultureofcode.diceware;

import java.util.Arrays;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class NumberGeneratorTest {

    private int min = 11111;
    private int max = 66666;

    @Test
    public void generate() {

        NumberGenerator numberGenerator = new NumberGenerator();

        for (int i = 0; i < 10000; i++) {
            Integer diceNum = numberGenerator.generate();
            assertThat(diceNum, greaterThanOrEqualTo(min));
            assertThat(diceNum, lessThanOrEqualTo(max));
        }
    }

    @Test
    public void generateValid() {
      NumberGenerator numberGenerator = new NumberGenerator();

        for (int i = 0; i < 10000; i++) {
            Integer diceNum = numberGenerator.generate();
            String s = String.valueOf(diceNum);
            s.chars().filter(digit -> digit == '0')
                    .forEach(digit -> fail("Generated bogus number " + diceNum));
            // TODO check for additional non-dice numbers (7,8,9)
        }
    }

    @Test
    public void generateSet() {

        NumberGenerator numberGenerator = new NumberGenerator();

        // scalacheck would be the bomb here!
        int[] setSize = {5,6,7,8,9,10};
        Arrays.stream(setSize).forEach(i -> {
            assertThat(numberGenerator.generate(i).size(), equalTo(i));
        });
    }

    @Test (expected = IllegalArgumentException.class)
    public void generateSetTooBig() {

        NumberGenerator numberGenerator = new NumberGenerator();
        // can you imagine?
        numberGenerator.generate(55556);
    }

    @Test (expected = IllegalArgumentException.class)
    public void generateSetTooSmall() {

        NumberGenerator numberGenerator = new NumberGenerator();
        // generator pleaze...
        numberGenerator.generate(1);
    }
}
