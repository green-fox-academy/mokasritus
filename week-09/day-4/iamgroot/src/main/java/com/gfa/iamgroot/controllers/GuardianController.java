package com.gfa.iamgroot.controllers;

import com.gfa.iamgroot.models.ErrorForGroot;
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
          .body(new ErrorForGroot());
    } else {
      return ResponseEntity.status(HttpStatus.OK).body(new SomeMessage(message));
    }
  }
}
