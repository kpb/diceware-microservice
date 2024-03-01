package com.cultureofcode.diceware;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class WordListGateway {

  private final URI effWordlist =
      URI.create("https://www.eff.org/files/2016/07/18/eff_large_wordlist.txt");
  private final URI backupWordlist =
      URI.create("https://theworld.com/~reinhold/diceware.wordlist.asc");


  Map<Integer, String> getWordList() {

    try {
      // TODO move the call to a method
      return parseWordlistLines(httpClient().send(effHttpRequest(), BodyHandlers.ofLines()).body());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Creates an HttpClient.
   *
   * @return a configured HttpClient
   */
  HttpClient httpClient() {
    return HttpClient.newHttpClient();
  }

  /**
   * Creates an HttpRequest to the EFF Diceware Wordlist URI.
   *
   * @return
   */
  HttpRequest effHttpRequest() {
    return HttpRequest.newBuilder(effWordlist).GET().build();
  }

  /**
   * Parses a stream of lines from the EFF Long Word List into a Hash of number:word. The file
   * currently can be found at https://www.eff.org/files/2016/07/18/eff_large_wordlist.txt
   *
   * @param lines A Stream of lines from a word list file
   * @return a hash of the Word List
   */
  Map<Integer, String> parseWordlistLines(Stream<String> lines) {

    Pattern dicewareNumberPattern = Pattern.compile("^\\d{5}\\s.*");

    return lines.filter(line -> dicewareNumberPattern.matcher(line).matches())
        .map(line -> line.split("\\s"))
        .collect(Collectors.toMap(a -> Integer.valueOf(a[0]), a -> a[1]));
  }

}
