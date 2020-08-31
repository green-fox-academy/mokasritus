package com.greenfoxacademy.bankofsimba.controllers;

import com.greenfoxacademy.bankofsimba.models.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BankAccountController {

@RequestMapping (value="/show")
  public String showOneAccount(Model model){
  BankAccount bankAccount=new BankAccount("Simba", 2000, "lion");
  model.addAttribute("bankAccount", bankAccount);
  return "show-one-bankaccount";
}
}
