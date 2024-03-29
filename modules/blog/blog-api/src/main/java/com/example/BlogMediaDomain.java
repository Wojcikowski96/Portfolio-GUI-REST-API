package com.example;

public interface BlogMediaDomain {
  Long getId();

  void setId(Long id);

  String getName();

  void setName(String name);

  String getType();

  void setType(String type);

  byte[] getImage();

  void setImage(byte [] image);

  String getImageUrl();

  void setImageUrl(String url);


}
