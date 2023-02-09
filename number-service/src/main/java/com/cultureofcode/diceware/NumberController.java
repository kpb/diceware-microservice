package com.cultureofcode.diceware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring MVC Controller for requesting Diceware numbers.
 *
 * @author kenneth
 */
@RestController
@RequestMapping(path = "/diceware")
public class NumberController {

  @Autowired
  NumberGenerator numberGenerator;

  /**
   * Get a Set of Diceware Numbers.
   *
   * @param length how many 5 digit diceware numbers in the Set?
   * @return
   */
  @GetMapping(path = "/numbers")
  public DicewareNumbers getNumbers(@RequestParam(name = "length", defaultValue = "5") int length) {

    return new DicewareNumbers(numberGenerator.generate(length));
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ClientError handleIllegalArgs(IllegalArgumentException iae) {

    return new ClientError(iae.getMessage());
  }
}
