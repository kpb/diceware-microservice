package com.cultureofcode.diceware;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Integration test of the WordListGateway
 */
public class WordListGatewayTest {


  @Test
  void testRetrieveWordListMap() {

    WordListGateway gw = new WordListGateway();
    assertThat(gw.getWordList()).as("Word list containts 7776 entries").hasSize(7776);
  }
}
