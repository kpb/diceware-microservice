package com.cultureofcode.diceware;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring boot and config class for the Diceware Web application.
 *
 * App is a Eureka client with support for Feign clients.
 *
 * @author kenneth
 */
@Configuration
@SpringBootApplication
public class DicewareWebApp {

  @Bean
  public PassphraseService passphraseService() {
  return new PassphraseService();
}

  @Bean
  public ObjectMapper objectMapper() {
      return new ObjectMapper();
  }

  public static void main(String[] args) {
    SpringApplication.run(DicewareWebApp.class, args);
  }
}
