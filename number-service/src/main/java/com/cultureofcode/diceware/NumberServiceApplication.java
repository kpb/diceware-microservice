package com.cultureofcode.diceware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring-boot application and config.
 *
 * @author kenneth
 */
@Configuration
@SpringBootApplication
public class NumberServiceApplication {

  /**
   * NumberGenerator Bean.
   * @return an instance of the NumberGenerator
   */
  @Bean
  NumberGenerator numberGenerator() {
    return new NumberGenerator();
  }

  /**
   * Spring Boot entrypoint.
   * @param args any args
   */
  public static void main(String[] args) {
    SpringApplication.run(NumberServiceApplication.class, args);
  }
}
