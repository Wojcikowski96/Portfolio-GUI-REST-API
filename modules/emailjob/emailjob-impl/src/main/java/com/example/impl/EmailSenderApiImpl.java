package com.example.impl;

import com.example.emailjob.EmailDomain;
import com.example.emailjob.EmailSenderApi;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.utils.exception.ExceptionsFactory;
import com.example.utils.model.SenderServiceModel;
import com.example.utils.repository.SenderServiceRepository;
import java.util.Optional;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderApiImpl implements EmailSenderApi {

  @Autowired
  UserRepository userRepository;

  @Autowired
  SenderServiceRepository senderServiceRepository;

  @Override
  public void sendMessage(EmailDomain domain) {

    Optional<User> user = Optional.ofNullable(
        userRepository.findById(1L).orElseThrow(
            () -> ExceptionsFactory.createNotFound(
                "Odbiorca wiadomości e-mail nie istnieje w bazie danych", "OWENIWBD", null)));

    Optional<SenderServiceModel> senderServiceData = Optional.ofNullable(
        senderServiceRepository.findById(1L).orElseThrow(
            () -> ExceptionsFactory.createNotFound(
                "Dane logowania dla serwisu wysyłkowego wiadomości e-mail nie istnieją w bazie danych",
                "DLDSWWE", null)));

    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost("smtp.poczta.onet.pl");
    mailSender.setPort(465);

    mailSender.setUsername(senderServiceData.get().getEmail());
    mailSender.setPassword(senderServiceData.get().getPassword());

    Properties properties = new Properties();
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.starttls.required", "true");
    properties.put("mail.smtp.ssl.enable", "true");


    mailSender.setJavaMailProperties(properties);

    SimpleMailMessage message = new SimpleMailMessage();

    message.setFrom(senderServiceData.get().getEmail());
    message.setTo(user.get().getEmail());
    message.setSubject(domain.getTittle());
    message.setText(domain.getContent());

    mailSender.send(message);

  }
}
