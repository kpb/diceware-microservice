package com.cultureofcode.diceware.cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class DicewareCLI {

    // TODO @Bean defs here

    public static void main(String[] args) {
        SpringApplication.run(DicewareCLI.class, args);
    }
}
