package com.cultureofcode.diceware.cli;

import com.cultureofcode.diceware.NumberGenerator;
import com.cultureofcode.diceware.WordList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Service class to bring together the diceware libs.
 *
 * @author Kenneth
 */
@Component
public class DicewareService {

    @Autowired
    NumberGenerator numberGenerator;

    @Autowired
    WordList wordList;

    /**
     * Generate a Set of 5 digit random numbers.
     *
     * @param num how many numbers?
     * @return a Set of random, 5 digit numbers - as if you rolled a dice
     */
    Set<Integer> generateNumbers(int num) {
        return numberGenerator.generate(num);
    }

    /**
     * Generate a passphrase.
     *
     * @param length How long?
     * @return
     */
    Map<Integer, String> generatePassphrase(int length) {

        Map<Integer, String> passphrase = new HashMap<>();

        generateNumbers(length).forEach(num -> {
            passphrase.put(num, wordList.getWord(num));
        });

        return passphrase;

    }

}
