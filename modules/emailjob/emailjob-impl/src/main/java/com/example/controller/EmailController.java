package com.example.controller;

import com.example.emailjob.EmailSenderApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
  @Autowired
  EmailSenderApi senderApi;

  @GetMapping("/email/send")
  public ResponseEntity<String> sendEmail(){
    senderApi.sendMessage();
    return ResponseEntity.ok("Wysłano");
  }
}
