package com.cultureofcode.diceware;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

/**
 * Generates Diceware random (enough) numbers: numbers between 11111 - 66666.
 * See http://world.std.com/~reinhold/diceware.html for more info.
 *
 * <em>Note</em>: the creator of diceware recommends that you DO NOT use software to create
 * a passphrase, which is exactly what we are doing here. He also mentions Java's SecureRandom is
 * good enough to use.
 */
public class NumberGenerator {

    int min = 11111;
    int max = 66666;

    /**
     *
     * @return a random-ish integer between 11111 and 66666
     */
    public Integer generate() {

        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(max - min) + min;
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

        Set<Integer> diceNums = new HashSet<Integer>();

        while (diceNums.size() < num) {
            diceNums.add(generate());
        }

        return diceNums;
    }
}
