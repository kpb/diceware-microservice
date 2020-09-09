package com.cultureofcode.diceware.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * REST client gateway to the Number Service.
 *
 * TODO rename to GateWay.
 *      implement WebClient
 *
 * @author kenneth
 */
public interface NumberServiceClient {

    @RequestMapping(path = "/diceware/numbers", method = RequestMethod.GET)
    public DicewareNumbers getNumbers(@RequestParam(name = "length") int length);

}
