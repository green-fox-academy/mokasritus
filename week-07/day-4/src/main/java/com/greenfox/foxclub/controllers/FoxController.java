package com.greenfox.foxclub.controllers;

import com.greenfox.foxclub.models.Drink;
import com.greenfox.foxclub.models.Food;
import com.greenfox.foxclub.models.Fox;
import com.greenfox.foxclub.services.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FoxController {
  private FoxService foxService;

  @Autowired
  public FoxController(FoxService foxService) {
    this.foxService = foxService;
  }

  @GetMapping(value = "/nutritionStore")
  public String renderNutritionPage(Model model, @RequestParam(required = false) String name) {
    Fox myFox = foxService.searchFoxWithName(name);
    model.addAttribute("name", myFox.getName());
    //kell hogy a nevet visszaadjuk az url-nek, különben name=null lesz
    model.addAttribute("foods", Food.class.getEnumConstants());
    model.addAttribute("drinks", Drink.class.getEnumConstants());
    return "nutritionstore";
  }

  @PostMapping(value = "/nutritionStore")
  public String chooseFoodAndDrink(@RequestParam(required = false) String name, String food, String drink) {
    //nem kell Model model mivel nem adunk át infót egy POST-os metód alatt a html-nek
    Fox myFox = foxService.searchFoxWithName(name);
    foxService.chooseFoodAndDrink(name, food, drink);
    return "redirect:/?name=" + name;
  }
}
