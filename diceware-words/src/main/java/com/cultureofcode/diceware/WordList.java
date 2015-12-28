package com.cultureofcode.diceware;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 *
 * @author kenneth
 */
public class WordList {

  String wordlistFile = "/diceware.wordlist.asc";

  Map<Integer, String> dicewordMap = new HashMap<>();

  public static WordList newInstance() {
    WordList wordList = new WordList();
    wordList.load();
    return wordList;
  }

  /**
   * Loads the diceware word list.
   */
  void load() {

    InputStream is = this.getClass().getResourceAsStream(wordlistFile);
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));

    Pattern dicewareNumberPattern = Pattern.compile("^\\d{5}\\s.*");

    Stream<String> lines = reader.lines();

    lines.filter(line -> dicewareNumberPattern.matcher(line).matches())
            .forEach(line -> {
              String[] tokens = line.split("\\s");
              dicewordMap.put(Integer.valueOf(tokens[0]), tokens[1]);
            });
  }

  public Map<Integer, String> getDicewordMap() {
    return dicewordMap;
  }
}
