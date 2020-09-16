package com.greenfoxacademy.frontend.controllers;


import com.greenfoxacademy.frontend.models.AppandA;
import com.greenfoxacademy.frontend.models.DoubledValue;
import com.greenfoxacademy.frontend.models.Error;
import com.greenfoxacademy.frontend.models.Factor;
import com.greenfoxacademy.frontend.models.GreatingSomeone;
import com.greenfoxacademy.frontend.models.NumberForUntil;
import com.greenfoxacademy.frontend.models.Sum;
import com.greenfoxacademy.frontend.services.MethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  public ResponseEntity doubleGivenNumber(@RequestParam(required = false) Integer input) {
    if (input == null) {
      return ResponseEntity.status(HttpStatus.OK).body(new Error("Please provide an input!"));
    } else {
      return ResponseEntity.status(HttpStatus.OK).body(new DoubledValue(input));
    }
  }

  @GetMapping(value = "/greeter")
  public ResponseEntity greetSomeone(@RequestParam(required = false) String name,
                                     @RequestParam(required = false) String title) {
    if (title == null && name == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new Error("Please provide a name and a title!"));
    } else if (name == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new Error("Please provide a name!"));
    } else if (title == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new Error("Please provide a title!"));
    } else {
      return ResponseEntity.status(HttpStatus.OK).body(new GreatingSomeone(name, title));
    }
  }

  @GetMapping(value = "/appenda/{appendable}")
  public ResponseEntity appandA(@PathVariable String appendable) {
    if (appendable == null) {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    } else {
      return ResponseEntity.status(HttpStatus.OK).body(new AppandA(appendable));
    }
  }

  @PostMapping(value = "/dountil/{action}")
  public ResponseEntity doUntil(@PathVariable String action,
                                @RequestBody(required = false) NumberForUntil numberForUntil) {
    if (numberForUntil == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new Error("Please provide a number!"));
    } else if (action.equals("sum")) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(new Sum(numberForUntil.getUntil()));
    } else if(action.equals("factor")) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(new Factor(numberForUntil.getUntil()));
    } return new ResponseEntity(HttpStatus.NOT_FOUND);
  }
}





