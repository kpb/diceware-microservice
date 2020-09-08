package com.cultureofcode.diceware;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Simple client error dto
 *
 * @author kenneth
 */
public class ClientError {

  @JsonProperty("error_msg")
  String errorMsg;

  ClientError(String message) {
    this.errorMsg = message;
  }

}
