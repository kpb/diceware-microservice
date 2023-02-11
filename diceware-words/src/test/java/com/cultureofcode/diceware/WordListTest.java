package com.cultureofcode.diceware;

import static org.assertj.core.api.Assertions.*;
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

    WordList wordList = WordList.newInstance();
    assertThat(wordList.getDicewordMap().size()).as("Word list containts 7776 entries")
        .isEqualTo(7776);
  }
}
