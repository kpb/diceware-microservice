package com.cultureofcode.diceware;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Getter;


/**
 * Word list implementation that loads the EFF word list off of the classpath.
 *
 * @author Kenneth
 */
public class WordList {

  /**
   * Package protected c-tor to force the use of the newInstance factory method.
   */
  WordList() {}

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

    dicewordMap.putAll(parseWordlistLines(reader.lines()));

    return this;
  }

  /**
   * Parses a stream of lines from the EFF Long Word List into a Hash of number:word. The file
   * currently can be found at https://www.eff.org/files/2016/07/18/eff_large_wordlist.txt
   *
   * @param lines A Stream of lines from a word list file
   * @return a hash of the Word List
   */
  Map<Integer, String> parseWordlistLines(Stream<String> lines) {

    Pattern dicewareNumberPattern = Pattern.compile("^\\d{5}\\s.*");

    return lines.filter(line -> dicewareNumberPattern.matcher(line).matches())
        .map(line -> line.split("\\s"))
        .collect(Collectors.toMap(a -> Integer.valueOf(a[0]), a -> a[1]));
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
