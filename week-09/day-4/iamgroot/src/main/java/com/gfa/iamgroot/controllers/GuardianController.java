package com.gfa.iamgroot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuardianController {

@GetMapping(value="/groot")
    public ResponsEntity translateMessage(@RequestParam(required=false) String message){

    }
}
