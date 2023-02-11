package com.cultureofcode.diceware.cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cultureofcode.diceware.NumberGenerator;
import com.cultureofcode.diceware.WordList;

@SpringBootApplication
@Configuration
public class DicewareCLI {

  @Bean
  NumberGenerator numberGenerator() {
    return new NumberGenerator();
  }

  @Bean
  WordList wordList() {
    return WordList.newInstance();
  }

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(DicewareCLI.class);
    app.setWebApplicationType(WebApplicationType.NONE);
    app.run(args);
  }
}
