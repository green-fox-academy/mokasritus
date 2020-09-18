package com.gfa.iamgroot.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;


@SpringBootTest
@AutoConfigureMockMvc
class GuardianControllerTest {

  private MockMvc mockMvc;

  @Autowired
  public GuardianControllerTest(MockMvc mockMvc) {
    this.mockMvc = mockMvc;
  }

  //With giving a parameter:
  //the status is ok
  //the given response is the same as expected

  @Test
  public void givenParameter_whenTranslateMessage_thenReturnStatusOkAndMessage() throws Exception {
    mockMvc.perform(get("/groot").param("message", "someMessage"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.received", is("someMessage")))
        .andExpect(jsonPath("$.translated", is("I am Groot!")));
  }

  //Without giving a parameter:
  //the status is not ok
  //the given error response is the same as expected

  @Test
  public void withoutGivenParameter_whenTranslateMessage_thenReturnStatusOkAndErrorMessage() throws Exception {
    mockMvc.perform(get("/groot"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error", is("I am Groot!")));
  }
}