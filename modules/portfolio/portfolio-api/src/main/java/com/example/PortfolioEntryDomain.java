package com.example;


import java.time.LocalDateTime;
import java.util.Set;

public interface PortfolioEntryDomain {

  String getTittle();

  void setTittle(String tittle);

  Long getId();

  void setId(Long id);

  String getWojewodztwo();

  void setWojewodztwo(String wojewodztwo);

  String getPowiat();

  void setPowiat(String powiat);

  String getProjectType();

  void setProjectType(String projectType);

  String getUrl();

  void setUrl(String url);

  LocalDateTime getCreationDate();

  LocalDateTime getModificationDate();

  void setCreationDate(LocalDateTime date);

  void setModificationDate(LocalDateTime date);

  String getAboutLocation();

  void setAboutLocation(String aboutLocation);

  String getCoatOfArmsDescription();

  void setCoatOfArmsDescription(String coatOfArmsDescription);

  String getSymbolsDescription();

  void setSymbolsDescription(String symbolsDescription);

  String getHistory();

  void setHistory(String history);

  LocalDateTime getCreatedAt();

  void setCreatedAt(LocalDateTime createdAt);

  Double getLongitude();

  void setLongitude(Double longitude);

  Double getLatitude();

  void setLatitude(Double latitude);




}

