package com.cultureofcode.diceware;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import lombok.Getter;


/**
 * Word list implementation that loads the EFF word list off of the classpath.
 *
 * @author kenneth
 */
public class WordList {

  /**
   * Private c-tor to force the use of the newInstance factory method.
   */
  private WordList() {}

  String wordlistFile = "/eff_large_wordlist.txt";

  @Getter
  Map<Integer, String> dicewordMap = new HashMap<>();

  /**
   * Create a new instance of the WordList.
   *
   * @return a WordList loaded with Diceware words.
   */
  public static WordList newInstance() {
    return new WordList().load();
  }

  /**
   * Loads the EFF diceware word list from a file on the classpath.
   *
   * @return this instance loaded with Diceware words
   */
  private WordList load() {

    InputStream is = this.getClass().getResourceAsStream(wordlistFile);
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));

    Pattern dicewareNumberPattern = Pattern.compile("^\\d{5}\\s.*");

    Stream<String> lines = reader.lines();

    lines.filter(line -> dicewareNumberPattern.matcher(line).matches()).forEach(line -> {
      String[] tokens = line.split("\\s");
      dicewordMap.put(Integer.valueOf(tokens[0]), tokens[1]);
    });
    return this;
  }

  /**
   * Get the Diceware word from the EFF list that corresponds to the provided number.
   *
   * @param num the number representing 5 rolls of a dice
   * @return the work corresponding to the number
   */
  public String getWord(int num) {
    return dicewordMap.get(num);
  }
}
