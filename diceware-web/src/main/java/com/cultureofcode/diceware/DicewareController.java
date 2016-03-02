package com.cultureofcode.diceware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring MVC Controller for generating Diceware passphrases. Only handles Controller concerns - delegates to the
 * PassphraseService.
 *
 * @author kenneth
 */
@RestController
public class DicewareController {

    @Autowired
    PassphraseService passphraseService;

    /**
     * Gets a passphrase with a default length of 7 words.
     *
     * @param length how many words in the passphrase?
     * @return a json representation of a Diceware passphrase {@link com.cultureofcode.diceware.client.DicewareNumbers}
     */
    @RequestMapping(path = "/passphrase", method = RequestMethod.GET)
    public DicewarePassphrase generatePassphrase(@RequestParam(name = "length", required = false, defaultValue = "7") Integer length) {

        return passphraseService.getPassphrase(length);
    }
}
