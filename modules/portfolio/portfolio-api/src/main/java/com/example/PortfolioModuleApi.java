package com.example;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PortfolioModuleApi {

  Page getPortfolioEntries(PortfolioEntryDomain portfolioEntryDomain, Pageable pageable);

  void savePortfolioEntry(PortfolioEntryDomain portfolioEntryDomain, PortfolioEntryDetailsDomain entryDetails);

  void deleteEntries(List<Long> ids);

  void uploadImage(ImageDomain imageDomain, Long entryId);
//
//  byte [] getImage(Long entryId);
}
