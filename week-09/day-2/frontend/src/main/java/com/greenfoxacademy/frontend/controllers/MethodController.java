package com.greenfoxacademy.frontend.controllers;


import com.greenfoxacademy.frontend.models.Entry;
import com.greenfoxacademy.frontend.models.Error;
import com.greenfoxacademy.frontend.models.Log;
import com.greenfoxacademy.frontend.models.arrayhandler.ObjectFromJson;
import com.greenfoxacademy.frontend.models.checkonwebsite.AppandA;
import com.greenfoxacademy.frontend.models.checkonwebsite.DoubledValue;
import com.greenfoxacademy.frontend.models.checkonwebsite.GreatingSomeone;
import com.greenfoxacademy.frontend.models.checkonwebsite.NumberForUntil;
import com.greenfoxacademy.frontend.services.LogService;
import com.greenfoxacademy.frontend.services.MethodService;
import java.util.Arrays;
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
  private LogService logService;

  @Autowired
  public MethodController(MethodService methodService, LogService logService) {
    this.methodService = methodService;
    this.logService = logService;
  }

  @GetMapping(value = "/doubling")
  public ResponseEntity doubleGivenNumber(@RequestParam(required = false) Integer input) {
    logService.save(new Log("/doubling", "input=" + input.toString()));
    if (input == null) {
      return ResponseEntity.status(HttpStatus.OK).body(new Error("Please provide an input!"));
    } else {
      return ResponseEntity.status(HttpStatus.OK).body(new DoubledValue(input));
    }
  }

  @GetMapping(value = "/greeter")
  public ResponseEntity greetSomeone(@RequestParam(required = false) String name,
                                     @RequestParam(required = false) String title) {
    logService.save(new Log("/greeter", "input=" + name + ", " + title));
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
    logService.save(new Log("/appenda", "input=" + appendable));
    if (appendable == null) {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    } else {
      return ResponseEntity.status(HttpStatus.OK).body(new AppandA(appendable));
    }
  }

  @PostMapping(value = "/dountil/{action}")
  public ResponseEntity doUntil(@PathVariable String action,
                                @RequestBody(required = false) NumberForUntil numberForUntil) {
    logService.save(new Log("/dountil", "input=" + numberForUntil.getUntil()));
    if (numberForUntil == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new Error("Please provide a number!"));
    } else {
      return ResponseEntity.status(HttpStatus.OK)
          .body(methodService.getResultValue(action, numberForUntil));
    }
  }

  @PostMapping(value = "/arrays")
  public ResponseEntity arrayHandler(@RequestBody(required = false) ObjectFromJson objectFromJson) {
    logService.save(new Log("/arrays", "input=" + objectFromJson.getWhat().toString() + ", " +
        Arrays.toString(objectFromJson.getNumbers())));
    if (objectFromJson.getWhat() == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new Error("Please provide what to do with the numbers!"));
    } else if (objectFromJson.getNumbers() == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new Error("Please provide the numbers!"));
    } else {
      return ResponseEntity.status(HttpStatus.OK).body(methodService.showResult(objectFromJson));
    }
  }

  @GetMapping(value = "/log")
  public ResponseEntity showLogDatas() {
    return ResponseEntity.status(HttpStatus.OK).body(new Entry(logService.showAllLog()));
  }
}





