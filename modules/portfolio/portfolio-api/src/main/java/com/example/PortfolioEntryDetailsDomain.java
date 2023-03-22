package com.example;

import java.util.List;

public interface PortfolioEntryDetailsDomain {

  String getAboutLocation();

  void setAboutLocation(String aboutLocation);

  String getCoatOfArmsDescription();

  void setCoatOfArmsDescription(String coatOfArmsDescription);

  String getSymbolsDescription();

  void setSymbolsDescription(String symbolsDescription);

  String getHistory();

  void setHistory(String history);

//  List<ImageDomain> getImages();
//
//  void setImages(List<ImageDomain> images);
}
