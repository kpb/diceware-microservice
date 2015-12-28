package com.cultureofcode.diceware;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

/**
 * Generates Diceware random (enough) numbers: numbers between 11111 - 66666. See
 * http://world.std.com/~reinhold/diceware.html for more info.
 *
 * <em>Note</em>: the creator of diceware recommends that you DO NOT use software to create a passphrase, which is
 * exactly what we are doing here. He also mentions Java's SecureRandom is good enough to use.
 */
public class NumberGenerator {

  SecureRandom rand = new SecureRandom();

  /**
   * Returns an integer made by throwing a dice 5 times.
   *
   * @return a random-ish integer between 11111 and 66666
   */
  public Integer generate() {

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < 5; i++) {
      sb.append(throwDice());
    }

    return Integer.valueOf(sb.toString());
  }

  Integer throwDice() {

    return rand.nextInt(6) + 1;
  }

  /**
   * Convenience for generating a set of 5 to 10 diceware numbers.
   *
   * @param num number to generate - must be between 5 and 10
   * @return a <i>num</i> size Set of random integers between 11111 and 66666
   */
  public Set<Integer> generate(int num) {

    if (num < 5 || num > 10) {
      throw new IllegalArgumentException("Can only generate between 5 & 10 diceware numbers");
    }

    Set<Integer> diceNums = new HashSet<>();

    while (diceNums.size() < num) {
      diceNums.add(generate());
    }

    return diceNums;
  }
}
