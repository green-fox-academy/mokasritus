package com.greenfoxacademy.webapplication.utilities.controllers;

import com.greenfoxacademy.webapplication.utilities.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UtilityController {

  // Use this `UtilityService` as a dependency for your controller.
  private UtilityService utilityService;

  @Autowired
  public UtilityController(UtilityService utilityService) {
    this.utilityService = utilityService;
  }
// ## First steps
// - Have a main page at `/useful`
// - This should contain links to all available utilities detailed below

  @RequestMapping(value = "/useful")
  public String listingUtilities() {
    return "mainpage";
  }

  // ## Colored Background
// - Have an endpoint `/useful/colored`
//     - should display an empty page with a random color background
// - Have a link at the main page to reach this endpoint

  @RequestMapping(value = "/useful/colored")
  public String emptyPageWithRandomColorBackground(Model model) {
    model.addAttribute("color", utilityService.randomColor());
    return "randombackgroundcolor";
  }

  // ## Email validator
// - Have an endpoint at `/useful/email` with a queryparam
// - Have a link at the main page to an example: `/useful/email?email=is@this.valid`
// - Display the following to the user
//     - `is@this.valid is a valid email address` in green
//     - `not_valid_email.com is not a valid email address` in red

  @RequestMapping(value = "/useful/email")
  public String validateEmail(Model model, @RequestParam String email) {
    String emailColor = utilityService.validateEmail(email);
    model.addAttribute("color", emailColor);
    String validationResult = "";
    if (emailColor.equals("green")) {
      validationResult = email + " is a valid email address";
    } else {
      validationResult = email + " is not a valid email address";
    }
    model.addAttribute("message", validationResult);
    return "mainpage";
  }

  // ## Caesar encoder/decoder
// - Caesar coding is just shifting every character in the text with a specific number of amount in the alphabet,
// coded `example` with `1` is `fybnqmf`._
// - Have two endpoints (one for encoding and one for decoding) with a `text` and `number` query param
// - Have a link at the main page for both
// - For encoding use the `number` value, for decoding use the `-number` value when calling the caesar() method.
//     - As a rule of usage: you cannot give negative value for the 'number' query param

  @RequestMapping(value = "/useful/encoder")
  public String ceaserEncoder(Model model, @RequestParam (required=false) String text, @RequestParam(required=false) int number) {
    model.addAttribute("encodedText", utilityService.caesar(text, number));
    return "mainpage";
  }

  @RequestMapping(value = "/useful/decoder")
  public String ceaserDecoder(Model model, @RequestParam (required=false) String text, @RequestParam(required=false) int number) {
    model.addAttribute("decodedText", utilityService.caesar(text, -number));
    return "mainpage";
  }
}
