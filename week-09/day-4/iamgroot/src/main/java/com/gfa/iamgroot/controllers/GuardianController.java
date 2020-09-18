package com.gfa.iamgroot.controllers;

import com.gfa.iamgroot.models.Arrow;
import com.gfa.iamgroot.models.ErrorForBadRequest;
import com.gfa.iamgroot.models.SomeMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuardianController {

  @GetMapping(value = "/groot")
  public ResponseEntity translateMessage(@RequestParam(required = false) String message) {
    if (message == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new ErrorForBadRequest("I am a groot!"));
    } else {
      return ResponseEntity.status(HttpStatus.OK).body(new SomeMessage(message));
    }
  }

  @GetMapping(value = "/yondu")
  public ResponseEntity calculateSpeed(@RequestParam(required = false) Float distance,
                                       @RequestParam(required = false) Float time) {
    if (distance == null && time == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new ErrorForBadRequest("Please provide a distance and a time!"));
    } else if (distance == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new ErrorForBadRequest("Please provide a distance!"));
    } else if (time == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new ErrorForBadRequest("Please provide a time!"));
    } else {
      return ResponseEntity.status(HttpStatus.OK).body(new Arrow(distance, time));
    }
  }
}

