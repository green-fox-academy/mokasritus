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
  private ServiceFox serviceFox;

  @Autowired
  public MainController(ServiceFox serviceFox) {
    this.serviceFox = serviceFox;
  }

  @RequestMapping(value = "/")
  public String showMainPage(Model model, @RequestParam(required = false) String name) {
    Fox myFox = findFoxWithName(name);
    model.addAttribute("myFox", myFox);
    return "index";
  }

  @GetMapping(value = "/login")
  public String login() {
    return "login";
  }

  @PostMapping(value = "/login")
  public String addNewFox(Model model, @RequestParam String name) {
    if (checkFoxIsExist(name)) {
      return "redirect:/?name=" + name;
    }
    serviceFox.addFox(name);
    return "redirect:/?name=" + name;
  }

  /*@GetMapping(value="/information")
  public String showMyFox(Model model, @RequestParam(required = false) String name){
    return "index";
  }*/

  private Fox findFoxWithName(String name) {
    return serviceFox.getFoxes().stream().filter(fox -> fox.getName().equals(name)).findFirst().get();
  }

  private Boolean checkFoxIsExist(String name){
    return serviceFox.getFoxes().stream().anyMatch(fox -> fox.getName().equals(name));
  }
}
