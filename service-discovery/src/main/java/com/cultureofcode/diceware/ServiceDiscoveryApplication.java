package com.cultureofcode.diceware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka Server Application for service discovery.
 *
 * @author kenneth
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoveryApplication {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(ServiceDiscoveryApplication.class, args);
  }
}
