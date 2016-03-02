package com.cultureofcode.diceware;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    PassphraseService passphraseService;

    @RequestMapping(path = "/passphrase", method = RequestMethod.GET)
    public DicewarePassphrase generatePassphrase(@RequestParam(name = "length", required = false, defaultValue = "7") Integer length) {

        return passphraseService.getPassphrase(length);
    }
}
