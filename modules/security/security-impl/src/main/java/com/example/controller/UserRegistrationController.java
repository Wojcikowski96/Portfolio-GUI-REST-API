package com.example.controller;

import com.example.model.UserRequest;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class UserRegistrationController {
  @Autowired
  UserService userService;

  @PostMapping("/register")
  public ResponseEntity register(@RequestBody UserRequest request) {

    ResponseEntity response;

    response = userService.registerUser(request);

    return response;

  }

}
