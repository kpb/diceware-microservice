/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cultureofcode.diceware;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Diceware passphrase DTO.
 *
 * @author kenneth
 */
public class DicewarePassphrase {

    // TODO json toString() & msg field

    @JsonProperty("passphrase")
    List<DicewareWord> passphrase = new ArrayList<>();

    public List<DicewareWord> getPassphrase() {
        return passphrase;
    }

    public DicewarePassphrase setPassphrase(List<DicewareWord> passphrase) {
        this.passphrase = passphrase;
        return this;
    }

    public DicewarePassphrase addWord(Integer num, String word) {
        passphrase.add(new DicewareWord()
            .setNumber(num).setWord(word));
        return this;
    }

    public static class DicewareWord {

        public Integer number;
        public String word;

        public DicewareWord setNumber(Integer number) {
            this.number = number;
            return this;
        }

        public DicewareWord setWord(String word) {
            this.word = word;
            return this;
        }

    }

}
