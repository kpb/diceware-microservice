package com.cultureofcode.diceware;

import com.cultureofcode.diceware.client.DicewareNumbers;
import com.cultureofcode.diceware.client.NumberServiceClient;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Composite service for getting a Diceware passphrase. Uses the number service and the word service via service clients
 * to access remote micro services.
 *
 * @author kenneth
 */
public class PassphraseService {

    @Autowired
    NumberServiceClient numberServiceClient;

    DicewarePassphrase getPassphrase(Integer length) {
        // TODO validate length

        DicewareNumbers dicewareNumbers = numberServiceClient.getNumbers(5);

        // hack
        System.out.println("*****");
        System.out.println(dicewareNumbers);

        // pass the numbers to the word service

        // TODO error handling


        // hard coded bullshit
        DicewarePassphrase passphrase = new DicewarePassphrase()
            .setPassphrase(getWords(length));

        return passphrase;
    }

    // hack
    private List<DicewarePassphrase.DicewareWord> getWords(Integer num) {
        List<DicewarePassphrase.DicewareWord> words = new ArrayList<>();
        words.add(new DicewarePassphrase.DicewareWord().setNumber(54321).setWord("ma"));
        words.add(new DicewarePassphrase.DicewareWord().setNumber(54321).setWord("mecca"));
        words.add(new DicewarePassphrase.DicewareWord().setNumber(54321).setWord("tao"));
        words.add(new DicewarePassphrase.DicewareWord().setNumber(54321).setWord("vulcan"));
        words.add(new DicewarePassphrase.DicewareWord().setNumber(54321).setWord("give"));
        words.add(new DicewarePassphrase.DicewareWord().setNumber(54321).setWord("drub"));
        words.add(new DicewarePassphrase.DicewareWord().setNumber(54321).setWord("dummy"));
        words.add(new DicewarePassphrase.DicewareWord().setNumber(54321).setWord("sue"));
        words.add(new DicewarePassphrase.DicewareWord().setNumber(54321).setWord("haiku"));

        return words.subList(0, num);
    }

}
