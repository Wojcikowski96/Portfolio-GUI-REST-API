package com.example.portfolio.impl;

import com.example.PortfolioEntryDetailsDomain;
import com.example.PortfolioEntryDomain;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PortfolioEntryDomainImpl implements PortfolioEntryDomain {
  private Long id;

  private String tittle;

  private PortfolioDetails portfolioDetails;

  private String url;

  private String wojewodztwo;

  private String powiat;

  private String projectType;

  private LocalDateTime creationDate;

  private LocalDateTime modificationDate;

  @Override
  public void setPortfolioDetails(PortfolioEntryDetailsDomain portfolioDetails) {
    this.portfolioDetails = (PortfolioDetails) portfolioDetails;
  }
}
