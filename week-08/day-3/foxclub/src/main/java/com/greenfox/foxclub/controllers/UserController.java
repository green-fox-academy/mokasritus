package com.greenfox.foxclub.controllers;

import com.greenfox.foxclub.models.FoxUser;
import com.greenfox.foxclub.services.FoxService;
import com.greenfox.foxclub.services.FoxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
  private FoxUserService foxUserService;

  @Autowired
  public UserController(FoxUserService foxUserService) {
    this.foxUserService = foxUserService;
  }

  @GetMapping(value = "/register")
  public String renderRegisterPage(Model model) {
    model.addAttribute("user", new FoxUser());
    return "register";
  }

  @PostMapping(value = "/register")
  public String registerNewUser(@ModelAttribute FoxUser foxUser,
                                @RequestParam String passwordAgain, RedirectAttributes attributes) {
    if (foxUserService.checkPasswords(foxUser.getPassword(), passwordAgain)) {
      foxUserService.saveNewFoxUser(foxUser);

      return "redirect:/login?id=" + foxUserService.findByUsername(foxUser.getUsername()).getId();
    } else {
      attributes.addFlashAttribute("error", "Passwords do not match!");
      return "redirect:/register";
    }
  }
}
