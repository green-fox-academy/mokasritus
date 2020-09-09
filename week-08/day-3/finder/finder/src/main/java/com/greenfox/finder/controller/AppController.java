package com.greenfox.finder.controller;

import com.greenfox.finder.service.UserService;
import com.greenfox.finder.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by aze on 25/10/17.
 */
@Controller
public class AppController {
    private UserService userservice;

    @Autowired
    public AppController(UserService userservice) {
        this.userservice = userservice;
    }


    @GetMapping(value="/app")
    public String renderMainPage(Model model) {
        model.addAttribute("new_user", new User());
        model.addAttribute("users", userservice.getAll());
        return "main";
    }

    @PostMapping("/add")
    public String create(User user) {
        userservice.save(user);
        return "redirect:/app";
    }
}