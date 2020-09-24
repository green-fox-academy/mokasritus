package com.greenfox.foxclub.controllers;

import com.greenfox.foxclub.models.Fox;
import com.greenfox.foxclub.models.FoxUser;
import com.greenfox.foxclub.services.FoxService;
import com.greenfox.foxclub.services.TrickService;
import com.greenfox.foxclub.services.FoxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
  private FoxService foxService;
  private FoxUserService foxUserService;
  private TrickService trickService;

  @Autowired
  public MainController(FoxService foxService, FoxUserService foxUserService, TrickService trickService) {
    this.foxService = foxService;
    this.foxUserService = foxUserService;
    this.trickService = trickService;
  }

  //megadhatok több endpointot is egyszerre {"", "", ...} formában
  @RequestMapping(value = {"/", "/information"})
  public String renderMainPage(Model model, @RequestParam(required = false) String name) {
    Fox myFox = foxService.searchFoxWithName(name);
    model.addAttribute("myFox", myFox);
    return "index";
  }

  @GetMapping(value = "/login")
  public String login(Model model, @RequestParam long id) {
    model.addAttribute("fox", new Fox());
    model.addAttribute("foxUser", foxUserService.findById(id));

    //odaadunk a login html-nek egy új üres Fox-ot th:object"${fox}" -al hívjuk meg a formban
    return "login";
  }

  //--------------------------------------------------------------------------------

  @PostMapping(value = "/login")
  //html form action=""-ben hívjuk meg + a megfelelő method=Post-al
  public String addNewFox(@RequestParam String name, @ModelAttribute Fox newFox, @RequestParam long id) {
    FoxUser foxuser = foxUserService.findById(id);
    foxuser.setFox(newFox);
    foxUserService.save(foxuser);
    Fox userFox =foxUserService.findById(id).getFox();
    foxService.deleteFoxWithoutName();
    return "redirect:/?name=" + userFox.getName();
  }

  @GetMapping(value = "/trickCenter")
  public String renderTrickCenterPage(Model model, @RequestParam(required = false) String name) {
    Fox myFox = foxService.searchFoxWithName(name);
    model.addAttribute("myfox", myFox);
    //kell hogy a nevet visszaadjuk az url-nek, különben name=null lesz
    model.addAttribute("tricks", trickService.getAllTricks());
    return "trickCenter";
  }

  @PostMapping(value = "/trickCenter")
  public String chooseTrickToLearn(@RequestParam(required = false) String name, String trick) {
    //trick a select name mezője!!!Névnek stimmelnie kell!!

    //nem kell Model model mivel nem adunk át infót egy POST-os metód alatt a html-nek
    Fox myFox = foxService.searchFoxWithName(name);
    foxService.addTrick(name, trickService.searchTrickWithName(trick));
    //foxService.addTrickToLearn(name, trickToLearn);
    return "redirect:/?name=" + myFox.getName();
  }
}
