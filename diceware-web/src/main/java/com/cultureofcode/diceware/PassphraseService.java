package com.cultureofcode.diceware;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kenneth
 */
public class PassphraseService {

  DicewarePassphrase getPassphrase(Integer length) {
    // TODO validate length

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
