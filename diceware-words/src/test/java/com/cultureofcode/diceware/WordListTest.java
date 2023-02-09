package com.cultureofcode.diceware;

import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
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
  public void testLoad() {

    WordList wordList = new WordList();
    wordList.load();
    assertThat(wordList.getDicewordMap().size()).as("Word list containts 7776 entries")
        .isEqualTo(7776);
  }
}
