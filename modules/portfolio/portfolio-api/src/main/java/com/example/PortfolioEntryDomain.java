package com.example;


import java.time.LocalDateTime;
import java.util.Set;

public interface PortfolioEntryDomain {

  String getTittle();

  void setTittle(String tittle);

  Long getId();

  void setId(Long id);

  PortfolioEntryDetailsDomain getPortfolioDetails();

  void setPortfolioDetails(PortfolioEntryDetailsDomain portfolioDetails);

  String getWojewodztwo();

  void setWojewodztwo(String wojewodztwo);

  String getPowiat();

  void setPowiat(String powiat);

  String getProjectType();

  void setProjectType(String projectType);

//  LocalDateTime getCreatedAt();
//
//  void setCreatedAt(LocalDateTime createdAt);

  String getUrl();

  void setUrl(String url);

  LocalDateTime getCreationDate();

  LocalDateTime getModificationDate();

  void setCreationDate(LocalDateTime date);

  void setModificationDate(LocalDateTime date);
}

