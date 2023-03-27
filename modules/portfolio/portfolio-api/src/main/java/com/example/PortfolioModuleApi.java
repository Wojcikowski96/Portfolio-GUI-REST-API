package com.example;

import com.example.utils.BlogImageDomainImpl;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PortfolioModuleApi {

  Page getPortfolioEntries(PortfolioEntryDomain portfolioEntryDomain, Pageable pageable);

  PortfolioEntryDetailsDomain getPortfolioEntryDetails(Long id);

  List<BlogImageDomainImpl> getPortfolioImageModels(Long entryId);

  void savePortfolioEntry(PortfolioEntryDomain portfolioEntryDomain, PortfolioEntryDetailsDomain entryDetails);

  void deleteEntries(List<Long> ids);

  void uploadImage(BlogImageDomain blogImageDomain, Long entryId);

  byte [] getImage(Long entryId, String name);
}
