package com.example.impl;

import com.example.emailjob.EmailDomain;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailDomainApiImpl implements EmailDomain {
  String tittle;

  String content;
}
