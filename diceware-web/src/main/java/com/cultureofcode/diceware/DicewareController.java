/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cultureofcode.diceware;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring MVC Controller for generating Diceware passphrases.
 *
 * @author kenneth
 */
// TODO look up services from Eureka and make actual calls.
@RestController
public class DicewareController {


  // TODO length
  @RequestMapping(path = "/passphrase", method = RequestMethod.GET)
  public DicewarePassphrase generatePassphrase() {

    return new DicewarePassphrase()
        .addWord(11111, "foo")
        .addWord(12345, "bar")
        .addWord(56849, "baz")
        .addWord(20394, "foobar")
        .addWord(45096, "bazbar")
        .addWord(75029, "bazfoo")
        .addWord(74930, "foobaz");
  }
}
