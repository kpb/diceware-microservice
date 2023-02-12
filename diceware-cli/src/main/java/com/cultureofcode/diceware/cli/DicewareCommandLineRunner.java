package com.cultureofcode.diceware.cli;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * CommandLineRunner impl for the Diceware microservice project.
 *
 * @author kenneth
 */
@Component
public class DicewareCommandLineRunner implements CommandLineRunner {

  @Autowired
  ApplicationContext ctx;

  @Autowired
  DicewareService dicewareService;

  String helpMessage = """
      Call the application with no args for interactive use.
      Provide an optional length between 3 and 10 to generate a passphase.
      """;

  @Override
  public void run(String... args) throws Exception {

    int words = 0;

    if (Arrays.asList(args).isEmpty()) {
      words = promptUser();
    } else if (args[0].equals("moo")) {
      System.out.println(moo);
      System.exit(SpringApplication.exit(ctx, (ExitCodeGenerator) () -> 0));
    } else {
      try {
        words = Integer.valueOf(args[0]);
      } catch (NumberFormatException nfe) {
        // print help and bail
        System.out.println("Unknown argument \"" + args[0] + "\"");
        System.out.println(helpMessage);
        System.exit(SpringApplication.exit(ctx, (ExitCodeGenerator) () -> 1));
      }
    }

    System.out.println("Generating a " + words + " word passphrase...");
    System.out.println();

    // generate the passphrase
    Map<Integer, String> passphrase = dicewareService.generatePassphrase(words);

    // output with formatting
    passphrase.values().forEach(word -> System.out.printf("%-10.10s", word));
    System.out.println();
    passphrase.keySet().forEach(num -> System.out.printf("%-10.10s", num));
    System.out.println();
    System.out.println("Enjoy your passphrase - be safe!");
    System.out.println();

    // exit.
    SpringApplication.exit(ctx, (ExitCodeGenerator) () -> 0);
  }

  /**
   * Prompt the user for a valid passphrase word length.
   */
  int promptUser() {

    try (Scanner scanner = new Scanner(System.in)) {
      int words = 5;

      System.out.print("How many words in the passphrase (default 5)? ");

      // assuming they want the default
      String line = scanner.nextLine();
      if (line.isEmpty()) {
        return words;
      }

      // handle NumberFormatException and illegal args
      try {
        int length = Integer.valueOf(line);

        if (length < 3 || length > 10) {
          System.out.println("Valid values must be between 3 & 10");
          return promptUser();
        }
        return length;

      } catch (NumberFormatException nfe) {
        System.out.println("Not a valid value");
        return promptUser();
      }
    }
  }

  String moo = """
    < Have you mooed today? >    $
     -----------------------     $
              ^__^               $
              (oo)\\_______      $
              (__)\\       )\\/\\$
                  ||----w |      $
                  ||     ||      $
        """.replace("$\n", "\n");
}
