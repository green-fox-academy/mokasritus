package com.greenfoxacademy.frontend.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.greenfoxacademy.frontend.models.checkonwebsite.DoubledValue;
import com.greenfoxacademy.frontend.services.LogService;
import com.greenfoxacademy.frontend.services.MethodService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class MethodControllerUnitTest {

  @Mock
  private MethodService methodService;

  @Mock
  private LogService logService;

  @InjectMocks
  private MethodController methodController;

  @Test
  void givenInput_whenDoubleGivenNumber_returndoubledValue(){
    Integer input = 5;
    ResponseEntity expected = ResponseEntity.status(
        HttpStatus.OK).body(new DoubledValue(input));

    ResponseEntity result = methodController.doubleGivenNumber(input);

    assertEquals(expected.getStatusCode(), result.getStatusCode());

  }
}
