package com.cultureofcode.diceware;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.BasicJsonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Number Controller integration tests. Tests using the complete Spring Context.
 *
 * @author kenneth
 */
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class NumberControllerIntegrationTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  private BasicJsonTester json;

  @Test
  public void getNumbers_defaultLength_returns5() throws Exception {

    String content = mockMvc.perform(get("/diceware/numbers")).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("diceware_numbers").isArray()).andReturn().getResponse()
        .getContentAsString();

    assertThat(json.from(content)).extractingJsonPathValue("diceware_numbers").asList().hasSize(5);
  }

  @Test
  public void getNumbers_lengthOf3_returns3() throws Exception {

    String content = mockMvc.perform(get("/diceware/numbers?length=3")).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("diceware_numbers").isArray()).andReturn().getResponse()
        .getContentAsString();

    assertThat(json.from(content)).extractingJsonPathValue("diceware_numbers").asList().hasSize(3);
  }

  @Test
  public void getNumbers_lengthof10_returns10() throws Exception {

    String content = mockMvc.perform(get("/diceware/numbers?length=10")).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("diceware_numbers").isArray()).andReturn().getResponse()
        .getContentAsString();

    assertThat(json.from(content)).extractingJsonPathValue("diceware_numbers").asList().hasSize(10);
  }

  @Test
  public void getNumbers_tooMany_badRequest() throws Exception {

    mockMvc.perform(get("/diceware/numbers?length=20")).andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
  }

  @Test
  public void getNumbers_tooFew_badRequest() throws Exception {

    mockMvc.perform(get("/diceware/numbers?length=1")).andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
  }
}
