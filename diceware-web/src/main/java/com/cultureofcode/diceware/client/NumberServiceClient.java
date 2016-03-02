package com.cultureofcode.diceware.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author kenneth
 */
@FeignClient(name = "diceware-number-service")
public interface NumberServiceClient  {

    @RequestMapping(path = "/diceware/numbers", method = RequestMethod.GET)
    public DicewareNumbers getNumbers(@RequestParam(name = "length") int length) ;

}
