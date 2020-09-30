package com.greenfoxacademy.frontend.controllers;


import com.greenfoxacademy.frontend.models.Entry;
import com.greenfoxacademy.frontend.models.Error;
import com.greenfoxacademy.frontend.models.Log;
import com.greenfoxacademy.frontend.models.arrayhandler.ObjectFromJson;
import com.greenfoxacademy.frontend.models.checkonwebsite.AppendA;
import com.greenfoxacademy.frontend.models.checkonwebsite.DoubledValue;
import com.greenfoxacademy.frontend.models.checkonwebsite.GreatingSomeone;
import com.greenfoxacademy.frontend.models.checkonwebsite.NumberForUntil;
import com.greenfoxacademy.frontend.models.sith.SithSentence;
import com.greenfoxacademy.frontend.services.LogServiceImpl;
import com.greenfoxacademy.frontend.services.MethodService;
import com.greenfoxacademy.frontend.services.SithService;
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
  private MethodService methodServiceImpl;
  private LogServiceImpl logServiceImpl;
  private SithService sithService;

  @Autowired
  public MethodController(MethodService methodServiceImpl, LogServiceImpl logServiceImpl, SithService sithService) {
    this.methodServiceImpl = methodServiceImpl;
    this.logServiceImpl = logServiceImpl;
    this.sithService = sithService;
  }

  @GetMapping(value = "/doubling")
  public ResponseEntity doubleGivenNumber(@RequestParam(required = false) Integer input) {
    if (input == null) {
      return ResponseEntity.status(HttpStatus.OK).body(new Error("Please provide an input!"));
    } else {
      //logServiceImpl.save(new Log("/doubling", "input=" + input.toString()));
      return ResponseEntity.status(HttpStatus.OK).body(new DoubledValue(input));
    }
  }

  @GetMapping(value = "/greeter")
  public ResponseEntity greetSomeone(@RequestParam(required = false) String name,
                                     @RequestParam(required = false) String title) {
    logServiceImpl.save(new Log("/greeter", "input=" + name + ", " + title));
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
    logServiceImpl.save(new Log("/appenda", "input=" + appendable));
    if (appendable == null) {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    } else {
      return ResponseEntity.status(HttpStatus.OK).body(new AppendA(appendable));
    }
  }

  @PostMapping(value = "/dountil/{action}")
  public ResponseEntity doUntil(@PathVariable String action,
                                @RequestBody(required = false) NumberForUntil numberForUntil) {
    if (numberForUntil==null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new Error("Please provide a number!"));
    } else {
      logServiceImpl.save(new Log("/dountil", "input=" + numberForUntil.getUntil()));
      return ResponseEntity.status(HttpStatus.OK)
          .body(methodServiceImpl.getResultValue(action, numberForUntil));
    }
  }

  @PostMapping(value = "/arrays")
  public ResponseEntity arrayHandler(@RequestBody(required = false) ObjectFromJson objectFromJson) {
    logServiceImpl.save(new Log("/arrays", "input=" + objectFromJson.getWhat().toString() + ", " +
        Arrays.toString(objectFromJson.getNumbers())));
    if (objectFromJson.getWhat() == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new Error("Please provide what to do with the numbers!"));
    } else if (objectFromJson.getNumbers() == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new Error("Please provide the numbers!"));
    } else {
      return ResponseEntity.status(HttpStatus.OK).body(methodServiceImpl.showResult(objectFromJson));
    }
  }

  @GetMapping(value = "/log")
  public ResponseEntity showLogDatas() {
    return ResponseEntity.status(HttpStatus.OK).body(new Entry(logServiceImpl.showAllLog()));
  }

  @PostMapping ("/sith")
  public ResponseEntity <Object> getResponse (@RequestBody SithSentence sithSentence){
    return ResponseEntity.status(HttpStatus.OK).body(sithService.createResponse(sithSentence.getText()));
  }
}





