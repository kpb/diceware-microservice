/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cultureofcode.diceware;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Simple client error dto
 * @author kenneth
 */
public class ClientError {

  @JsonProperty("error_msg")
  String errorMsg;

  ClientError(String message) {
    this.errorMsg = message;
  }

}
