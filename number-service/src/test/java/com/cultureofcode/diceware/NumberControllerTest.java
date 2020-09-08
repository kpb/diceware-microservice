package com.cultureofcode.diceware;

import static org.hamcrest.collection.IsCollectionWithSize.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 *
 * @author kenneth
 */
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class NumberControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  public void getDefaultLength() throws Exception {

    mockMvc.perform(get("/diceware/numbers")).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("diceware_numbers").isArray())
        .andExpect(jsonPath("diceware_numbers", hasSize(5)));
  }

  @Test
  public void get3() throws Exception {

    mockMvc.perform(get("/diceware/numbers?length=3")).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("diceware_numbers").isArray())
        .andExpect(jsonPath("diceware_numbers", hasSize(3)));
  }

  @Test
  public void get10() throws Exception {

    mockMvc.perform(get("/diceware/numbers?length=10")).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("diceware_numbers").isArray())
        .andExpect(jsonPath("diceware_numbers", hasSize(10)));
  }

  @Test
  public void getTooMany() throws Exception {

    mockMvc.perform(get("/diceware/numbers?length=20")).andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
  }

  @Test
  public void getTooFew() throws Exception {

    mockMvc.perform(get("/diceware/numbers?length=1")).andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
  }
}
