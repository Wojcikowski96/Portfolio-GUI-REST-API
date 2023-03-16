package com.example.impl;

import com.example.emailjob.EmailSenderApi;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.utils.exception.ExceptionsFactory;
import java.util.Optional;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderApiImpl implements EmailSenderApi {

  @Autowired
  UserRepository userRepository;

  @Override
  public void sendMessage() {

    Optional<User> user = Optional.ofNullable(
        userRepository.findById(1L).orElseThrow(
            () -> ExceptionsFactory.createNotFound(
                "Odbiorca wiadomości e-mail nie istnieje w bazie danych", "OWENIWBD", null)));

    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//    mailSender.setHost("imap.gmail.com");
    mailSender.setPort(587);

    mailSender.setUsername("janusztestowy343@gmail.com");
    mailSender.setPassword("Borutta666");

    Properties properties = new Properties();
    properties.put("mail.imap.ssl.enable", "true"); // required for Gmail
    properties.put("mail.imap.sasl.enable", "true");
    properties.put("mail.imap.sasl.mechanisms", "XOAUTH2");
    properties.put("mail.imap.auth.login.disable", "true");
    properties.put("mail.imap.auth.plain.disable", "true");

    mailSender.setJavaMailProperties(properties);

    SimpleMailMessage message = new SimpleMailMessage();

    message.setFrom("wojcikowski1@gmail.com");
    message.setTo("janusztestowy343@gmail.com");
    message.setSubject("This is a plain text email");
    message.setText("Hello guys! This is a plain text email.");

    mailSender.send(message);

  }
}
