package com.example;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PortfolioModuleApi {

  Page getPortfolioEntries(PortfolioEntryDomain portfolioEntryDomain, Pageable pageable);

  PortfolioEntryDetailsDomain getPortfolioEntryDetails(Long id);

  List getPortfolioMediaModels(Long entryId);

  void savePortfolioEntry(PortfolioEntryDomain portfolioEntryDomain, PortfolioEntryDetailsDomain entryDetails);

  void deleteEntries(List<Long> ids);

  void uploadImage(PortfolioMediaDomain portfolioMediaDomain, Long entryId);

  void uploadDocument(PortfolioMediaDomain portfolioMediaDomain, Long entryId);

  byte [] getMedia(Long entryId, String name);

}
