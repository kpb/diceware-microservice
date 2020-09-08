package com.cultureofcode.diceware.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign client for calling the diceware-number-service. Look how little code it takes to be a REST client!
 *
 * @author kenneth
 */
@FeignClient(name = "diceware-number-service")
public interface NumberServiceClient {

    @RequestMapping(path = "/diceware/numbers", method = RequestMethod.GET)
    public DicewareNumbers getNumbers(@RequestParam(name = "length") int length);

}
