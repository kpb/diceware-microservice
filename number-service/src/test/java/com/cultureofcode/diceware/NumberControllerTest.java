/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cultureofcode.diceware;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.collection.IsCollectionWithSize.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 *
 * @author kenneth
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(NumberService.class)
@WebAppConfiguration
public class NumberControllerTest {

  @Autowired
  private WebApplicationContext webContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.webContext).build();
    }

    @Test
    public void getDefaultLength() throws Exception {

      mockMvc.perform(get("/diceware/numbers"))
              .andExpect(status().isOk())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
              .andExpect(jsonPath("diceware_numbers").isArray())
              .andExpect(jsonPath("diceware_numbers", hasSize(5)))
              ;
    }

    @Test
    public void get3() throws Exception {

      mockMvc.perform(get("/diceware/numbers?length=3"))
              .andExpect(status().isOk())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
              .andExpect(jsonPath("diceware_numbers").isArray())
              .andExpect(jsonPath("diceware_numbers", hasSize(3)))
              ;
    }

    @Test
    public void get10() throws Exception {

      mockMvc.perform(get("/diceware/numbers?length=10"))
              .andExpect(status().isOk())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
              .andExpect(jsonPath("diceware_numbers").isArray())
              .andExpect(jsonPath("diceware_numbers", hasSize(10)))
              ;
    }

    @Test
    public void getTooMany() throws Exception {

      mockMvc.perform(get("/diceware/numbers?length=20"))
              .andExpect(status().isBadRequest())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
              ;
    }

    @Test
    public void getTooFew() throws Exception {

      mockMvc.perform(get("/diceware/numbers?length=1"))
              .andExpect(status().isBadRequest())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
              ;
    }
}
