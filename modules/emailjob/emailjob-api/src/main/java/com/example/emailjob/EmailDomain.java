package com.example.emailjob;

public interface EmailDomain {
  String getTittle();
  String getContent();

  String getEmail();

  String getNick();
  void setTittle(String tittle);
  void setContent(String description);

  void setEmail(String content);

  void setNick(String nickname);


}
