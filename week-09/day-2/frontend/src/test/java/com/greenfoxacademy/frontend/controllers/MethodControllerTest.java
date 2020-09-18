package com.greenfoxacademy.frontend.controllers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfoxacademy.frontend.models.checkonwebsite.DoubledValue;
import com.greenfoxacademy.frontend.models.checkonwebsite.NumberForUntil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class MethodControllerTest {

  private MockMvc mockMvc;

  @Autowired
  public MethodControllerTest(MockMvc mockMvc) {
    this.mockMvc = mockMvc;
  }

  @Test
  void givenInteger_whenDoubleGivenNumber_thenReturnDoubledValueOfInteger() throws Exception {
    mockMvc.perform(get("/doubling").param("input", "5"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.result").value(new DoubledValue(5).getResult()));
  }

  @Test
  void givenNameAndTitle_whenGreetSomeone_thenReturnStatusOK() throws Exception {
    mockMvc.perform(get("/greeter")
        .param("name", "Rita")
        .param("title", "Student"))
        // mockMvc.perform(get("/greeter?name=Rita&&title=Student"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.welcome_message", is("Oh, hi there Rita, my dear Student!")));
  }

  @Test
  void givenOnlyName_whenGreetSomeone_thenReturnStatusBadRequest() throws Exception {
    mockMvc.perform(get("/greeter?name=Rita"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").value("Please provide a title!"));
  }

  @Test
  void givenOnlyTitle_whenGreetSomeone_thenReturnStatusBadRequestWithErrorMessage()
      throws Exception {
    mockMvc.perform(get("/greeter?title=Student"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").value("Please provide a name!"));
  }

  @Test
  void givenAppendable_whenAppandA_thenReturnStatusOkWithAppendA() throws Exception {
    mockMvc.perform(get("/appenda/Rit"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.appended", is("Rita")));
  }

  @Test
  void givenWithoutAppendable_whenAppandA_thenReturnNotFound() throws Exception {
    mockMvc.perform(get("/appenda"))
        .andExpect(status().isNotFound());
  }

  @Test
  void givenActionAndJsonObject_whenDoUntil_returnStatusOk() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    String item = objectMapper.writeValueAsString(new NumberForUntil(5));
    mockMvc.perform(post("/dountil/sum").content(item).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.result").value(15));
  }

  @Test
  void givenActionWithoutObject_whenDoUntil_returnStatusBadRequestWithErrorMessage()
      throws Exception {

    mockMvc.perform(post("/dountil/sum"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error", is("Please provide a number!")));
  }

  @Test
  void arrayHandler() {
  }

}