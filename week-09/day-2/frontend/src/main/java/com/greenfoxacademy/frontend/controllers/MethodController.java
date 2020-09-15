package com.greenfoxacademy.frontend.controllers;


import com.greenfoxacademy.frontend.models.DoubledValue;
import com.greenfoxacademy.frontend.models.InputError;
import com.greenfoxacademy.frontend.services.MethodService;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MethodController {
  private MethodService methodService;

  @Autowired
  public MethodController(MethodService methodService) {
    this.methodService = methodService;
  }

  @GetMapping(value = "/doubling")
  public ResponseEntity doubleGivenNumber(@RequestParam(required=false) Integer input) {
    if (input==null) {
      return ResponseEntity.status(HttpStatus.OK).body(new InputError());
    }else {
      return ResponseEntity.status(HttpStatus.OK).body(new DoubledValue(input));
    }
  }
  //ResponseEntity<DoubledValue>
}
