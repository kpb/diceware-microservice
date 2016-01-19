
package com.cultureofcode.diceware.cli;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author kenneth
 */
@Component
public class DicewareCommandLineRunner implements CommandLineRunner {

  @Autowired
  ApplicationContext ctx;

  @Override
  public void run(String... strings) throws Exception {

    int words = promptUser();
    System.out.println("Generating a passphrase " + words + " words long...");

    // TODO app logic

    // exit. thanks for the Lambda, java 8!
    SpringApplication.exit(ctx, (ExitCodeGenerator) () -> 0);
  }

  /**
   * Prompt the user for a valid passphrase word length.
   */
  int promptUser() {

    try (Scanner scanner = new Scanner(System.in)) {
      int words = 5;

      System.out.print("How many words in the passphrase (default 5)? ");

      String line = scanner.nextLine();
      if (line.isEmpty()) {
        return words;
      } else {
        // handle NumberFormatException
        try {
          return Integer.valueOf(line);
        } catch (NumberFormatException nfe) {
          System.out.println("Not Valid");
          return promptUser();
        }
      }
    }
  }
}
