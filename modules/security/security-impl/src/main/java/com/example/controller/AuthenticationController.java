package com.example.controller;

import com.example.filter.JwtUtils;
import com.example.model.UserRequest;
import com.example.service.MyUserDetailsService;
import com.example.utils.exception.ExceptionsFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class AuthenticationController {

  private final AuthenticationManager authenticationManager;

  private final MyUserDetailsService myUserDetailsService;

  private final JwtUtils jwtUtils;

  @PostMapping("/authenticate")
  public ResponseEntity<String> authenticate(@RequestBody UserRequest request) {


    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
    } catch (DisabledException e) {
      throw ExceptionsFactory.createForbidden("User disabled", "UD", e);
    } catch (BadCredentialsException e) {
      throw ExceptionsFactory.createForbidden("Niepoprawne dane logowania", "NDL",
          e);
    }

    final UserDetails user = myUserDetailsService.loadUserByUsername(request.getEmail());

    return ResponseEntity.ok(jwtUtils.generateToken(user));

  }

}
