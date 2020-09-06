package com.greenfox.foxclub.controllers;

import com.greenfox.foxclub.models.Fox;
import com.greenfox.foxclub.services.ServiceFox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
  private ServiceFox service;

  @Autowired
  public MainController(ServiceFox service) {
    this.service = service;
  }

  //megadhatok több endpointot is egyszerre {"", "", ...} formában
  @RequestMapping(value = {"/", "/information"})
  public String renderMainPage(Model model, @RequestParam(required = false) String name) {
    Fox myFox = service.searchFoxWithName(name);
    model.addAttribute("myFox", myFox);
    model.addAttribute("name", myFox.getName());
    return "index";
  }

  @GetMapping(value = "/login")
  public String login(Model model) {
    model.addAttribute("fox", new Fox());
    //odaadunk a login html-nek egy új üres Fox-ot th:object"${fox}" -al hívjuk meg a formban
    return "login";
  }

  @PostMapping(value = "/login")
  //html form action=""-ben hívjuk meg + a megfelelő method=Post-al
  public String addNewFox(@RequestParam String name, Fox newFox) {
    service.addFox(newFox);
    return "redirect:/?name=" + newFox.getName();
  }

}
