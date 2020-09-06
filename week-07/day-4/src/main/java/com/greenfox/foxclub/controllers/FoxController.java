package com.greenfox.foxclub.controllers;

import com.greenfox.foxclub.models.Drink;
import com.greenfox.foxclub.models.Food;
import com.greenfox.foxclub.models.Fox;
import com.greenfox.foxclub.services.ServiceFox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FoxController {
  private ServiceFox serviceFox;

  @Autowired
  public FoxController(ServiceFox serviceFox) {
    this.serviceFox = serviceFox;
  }

  @GetMapping(value = "/nutritionStore")
  public String renderNutritionPage(Model model, @RequestParam(required = false) String name) {
    Fox myFox = serviceFox.searchFoxWithName(name);
    model.addAttribute("name", myFox.getName());
    model.addAttribute("foods", Food.class.getEnumConstants());
    model.addAttribute("drinks", Drink.class.getEnumConstants());
    return "nutritionstore";
  }

  @PostMapping(value = "/nutritionStore")
  public String chooseFoodAndDrink(@RequestParam(required = false) String name, String food, String drink) {
    Fox myFox = serviceFox.searchFoxWithName(name);
    serviceFox.chooseFoodAndDrink(name, food, drink);
    return "redirect:/?name=" + name;
  }


}
