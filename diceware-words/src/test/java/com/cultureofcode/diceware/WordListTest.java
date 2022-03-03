package com.cultureofcode.diceware;

import static org.junit.jupiter.api.Assertions.*;
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
    assertEquals(wordList.getDicewordMap().size(), 7776);
  }

  // TODO implement proper test
  // @Test
  public void testMap() {

    List<Integer> nums = new ArrayList<>();

    for (int i = 11111; i < 66667; i++) {
      nums.add(i);
    }

    List<Integer> remove = new ArrayList<>();
    for (Integer num : nums) {

      // int n = num;
      int n = 66601;
      while (n > 0) {
        n = n % 10;
        System.out.println(n);

        if (n == 0 || n > 6) {
          remove.add(num);
        }
        n /= 10;
      }
      /*
       * while (n > 0) {n digits.add(n%10); n/=10; }
       */
    }
    nums.removeAll(remove);
    nums.stream().forEach((x) -> {
      // System.out.println(x);
    });



  }
}
