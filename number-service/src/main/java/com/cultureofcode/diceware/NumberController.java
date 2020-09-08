/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cultureofcode.diceware;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring MVC Controller for generating Diceware numbers.
 *
 * @author kenneth
 */
@RestController
@RequestMapping(path="/diceware")
public class NumberController {

  @Autowired
  NumberGenerator numberGenerator;

  /**
   * Get a Set of Diceware Numbers.
   *
   * @param length how many 5 digit diceware numbers in the Set?
   * @return
   */
  @RequestMapping(path = "/numbers", method = RequestMethod.GET)
  public DicewareNumbers getNumbers(@RequestParam(name = "length", defaultValue = "5") int length) {

    return new DicewareNumbers().setDicewareNumbers(numberGenerator.generate(length));
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ClientError handleIllegalArgs(IllegalArgumentException iae, HttpServletResponse resp) {

    resp.setStatus(HttpStatus.BAD_REQUEST.value());
    return new ClientError(iae.getMessage());

  }
}
