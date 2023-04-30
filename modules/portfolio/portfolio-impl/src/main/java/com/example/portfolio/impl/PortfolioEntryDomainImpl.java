package com.example.portfolio.impl;

import com.example.PortfolioEntryDomain;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PortfolioEntryDomainImpl implements PortfolioEntryDomain {
  private Long id;

  private String tittle;

  private String url;

  private String wojewodztwo;

  private String powiat;

  private String projectType;

  private LocalDateTime creationDate;

  private LocalDateTime modificationDate;

  private String aboutLocation;

  private String coatOfArmsDescription;

  private String symbolsDescription;

  private String history;


}
