package com.example.portfolio.impl;

import com.example.PortfolioEntryDetailsDomain;
import com.example.blog.impl.ImageDomainImpl;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PortfolioDetails implements PortfolioEntryDetailsDomain {

  private String aboutLocation;

  private String coatOfArmsDescription;

  private String symbolsDescription;

  private String history;

//  List<ImageDomainImpl> images;
}
