package com.gfa.movieapi.controllers;

import com.gfa.movieapi.models.AuthenticationRequest;
import com.gfa.movieapi.models.AuthenticationResponse;
import com.gfa.movieapi.models.MyUserDetails;
import com.gfa.movieapi.services.MyUserDetailsService;
import com.gfa.movieapi.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private MyUserDetailsService myUserDetailsService;

  @Autowired
  private JwtUtil jwtUtil;


  @GetMapping({"/", "/hello"})
  public String home() {
    return "hello world!";
  }

  @PostMapping("/authenticate")
  public ResponseEntity<?> createAuthenticationToken(
      @RequestBody AuthenticationRequest authenticationRequest)
      throws Exception {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
              authenticationRequest.getPassword()));
    } catch (BadCredentialsException e) {
      throw new Exception("Incorrect username or password", e);
    }
    final UserDetails userDetails =
        myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
    final String jwt = jwtUtil.generateToken(userDetails);
    return ResponseEntity.ok(new AuthenticationResponse(jwt));
  }

  @GetMapping("/user")
  public String user() {
    return "hello User!";
  }

  @GetMapping("/admin")
  public String admin() {
    return "Hello Admin!";
  }
}
