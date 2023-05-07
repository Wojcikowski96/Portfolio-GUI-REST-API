package com.example.portfolio.impl;

import com.example.PortfolioMediaDomain;

public class PortfolioMediaDomainImpl implements PortfolioMediaDomain {
  Long id;

  private String name;

  private String type;

  private byte[] image;

  private String url;

  private String extensionType;

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getType() {
    return this.type;
  }

  @Override
  public void setType(String type) {
    this.type = type;
  }

  @Override
  public byte[] getImage() {
    return this.image;
  }

  @Override
  public void setImage(byte[] image) {
    this.image = image;
  }

  @Override
  public String getImageUrl() {
    return this.url;
  }

  @Override
  public void setImageUrl(String url) {
    this.url = url;

  }

  @Override
  public String getExtensionType() {
    return this.extensionType;
  }

  @Override
  public void setExtensionType(String extensionType) {
    this.extensionType = extensionType;
  }
}
