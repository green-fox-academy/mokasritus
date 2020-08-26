package com.greenfoxacademy.springstart.controllers;

import com.greenfoxacademy.springstart.models.Greeting;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRESTController{
  AtomicLong greetingsCounter = new AtomicLong(0);
  /*@RequestMapping(value = "/greeting")
  public Greeting greeting() {
    return new Greeting(1, "Hello, World!");
  }*/

  @RequestMapping(value = "/greeting")
  public Greeting greeting(@RequestParam String name) {
    return new Greeting(greetingsCounter.getAndIncrement(), "Hello, " + name);
  }
}


