/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cultureofcode.diceware;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Diceware passphrase DTO.
 *
 * @author kenneth
 */
public class DicewarePassphrase {

  @JsonProperty("passphrase")
  Map<Integer, String> passPhrase = new LinkedHashMap<>();


  /**
   * Add a word to the passphrase
   * @param num the diceware 'number' - as if a dice was rolled 5 times
   * @param word the corresponding word from the diceware word list
   * @return this for great train wreck
   */
  public DicewarePassphrase addWord(Integer num, String word) {

    passPhrase.put(num, word);
    return this;
  }

  public Map<Integer, String> getPassPhrase() {
    return passPhrase;
  }

  public void setPassPhrase(Map<Integer, String> passPhrase) {
    this.passPhrase = passPhrase;
  }
}
