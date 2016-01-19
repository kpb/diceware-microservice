package com.cultureofcode.diceware.cli;

import com.cultureofcode.diceware.NumberGenerator;
import com.cultureofcode.diceware.WordList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class DicewareCLI {

    // TODO @Bean defs here
    @Bean
    NumberGenerator numberGenerator() {
        return new NumberGenerator();
    }

    @Bean
    WordList wordList() {
        return WordList.newInstance();
    }

    public static void main(String[] args) {
        SpringApplication.run(DicewareCLI.class, args);
    }
}
