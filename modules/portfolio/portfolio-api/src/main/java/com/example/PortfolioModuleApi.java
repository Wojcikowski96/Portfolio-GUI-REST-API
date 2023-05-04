package com.example;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PortfolioModuleApi {

  Page getPortfolioEntries(PortfolioEntryDomain portfolioEntryDomain, Pageable pageable);

  List getPortfolioMediaModels(Long entryId);

  void savePortfolioEntry(PortfolioEntryDomain portfolioEntryDomain);

  void deleteEntries(List<Long> ids);

  void deleteImage(Long imageId);

  void uploadImage(PortfolioMediaDomain portfolioMediaDomain, Long entryId);

  void uploadDocument(PortfolioMediaDomain portfolioMediaDomain, Long entryId);

  byte [] getMedia(Long entryId, String name);

}
