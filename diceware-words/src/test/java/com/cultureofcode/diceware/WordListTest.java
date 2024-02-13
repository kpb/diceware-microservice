package com.cultureofcode.diceware;

import static org.assertj.core.api.Assertions.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kenneth
 */
public class WordListTest {

  /**
   * Test of load method, of class WordList.
   */
  @Test
  public void NewInstance_DefaultWordList_7776Entries() {

    WordList wordList = WordList.newInstance();
    assertThat(wordList.getDicewordMap()).as("Word list containts 7776 entries")
        .hasSize(7776);
  }

  @Test
  public void ParseWordlistLines_ReiholdList_7776Entries() {

    WordList wordList = new WordList();

    BufferedReader reader = new BufferedReader(
        new InputStreamReader(this.getClass().getResourceAsStream("/diceware.wordlist.asc")));
    assertThat(wordList.parseWordlistLines(reader.lines()))
        .as("Word list containts 7776 entries").hasSize(7776);
  }
}
