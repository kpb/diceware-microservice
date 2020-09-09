package com.cultureofcode.diceware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring-boot and config class.
 *
 * @author kenneth
 */
@Configuration
@SpringBootApplication
public class NumberService {

  @Bean
  NumberGenerator numberGenerator() {
    return new NumberGenerator();
  }

  public static void main(String[] args) {
    SpringApplication.run(NumberService.class, args);
  }
}
