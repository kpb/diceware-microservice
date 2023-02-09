package com.cultureofcode.diceware;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Simple client error dto.
 *
 * @author kenneth
 */
record ClientError(@JsonProperty("error_msg") String errorMsg) {
}
