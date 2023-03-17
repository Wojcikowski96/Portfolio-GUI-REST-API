package com.example.impl;

import com.example.EmailApiDelegate;
import com.example.emailjob.EmailSenderApi;
import com.example.mapper.EmailMapper;
import com.example.model.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EmailApiDelegateImpl implements EmailApiDelegate {
  @Autowired
  EmailSenderApi senderApi;

  @Autowired
  EmailMapper emailMapper;

  @Override
  public ResponseEntity<Void> sendMessage(EmailDTO emailDTO) {

    senderApi.sendMessage(emailMapper.restToDomain(emailDTO));

    return ResponseEntity.noContent().build();
  }
}
