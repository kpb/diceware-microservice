package com.cultureofcode.diceware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring boot and config class for the Diceware Web application.
 *
 * @author kenneth
 */
@Configuration
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class DicewareWebApp {

  @Bean
  public PassphraseService passphraseService() {
  return new PassphraseService();
}

  public static void main(String[] args) {
    SpringApplication.run(DicewareWebApp.class, args);
  }
}
