package com.greenfoxacademy.basicwebshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BasicWebshopController {

  @RequestMapping("/webshop")
  public String readerMainPage (){
    return "index";
  }
}
