package com.cultureofcode.diceware;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

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
    assertThat(wordList.getDicewordMap().size(), equalTo(7776));
  }

  //@Test
  public void testMap() {

    List<Integer> nums = new ArrayList<>();

    for (int i = 11111; i < 66667; i++) {
      nums.add(i);
    }

    List<Integer> remove = new ArrayList<>();
    for (Integer num : nums) {

      //int n = num;
      int n = 66601;
      while (n > 0) {
        n = n%10;
        System.out.println(n);

        if (n == 0 || n > 6) {
          remove.add(num);
        }
        n/=10;
      }
/*
 while (n > 0) {n
     digits.add(n%10);
     n/=10;
 } */
    }
    nums.removeAll(remove);
    nums.stream().forEach((x) -> {
      //System.out.println(x);
    });



  }
}
