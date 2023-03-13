package com.example;

import jakarta.persistence.Column;

public interface ImageDomain {
  Long getId();

  void setId(Long id);

  String getName();

  void setName(String name);

  String getType();

  void setType(String type);

  byte[] getImage();

  void setImage(byte [] image);

  String getUrl();

  void setUrl(String url);


}
