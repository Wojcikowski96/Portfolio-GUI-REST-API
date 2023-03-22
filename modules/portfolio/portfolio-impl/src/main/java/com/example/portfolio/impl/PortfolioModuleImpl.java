package com.example.portfolio.impl;

import com.example.PortfolioEntryDetailsDomain;
import com.example.PortfolioEntryDomain;
import com.example.PortfolioModuleApi;
import com.example.portfolio.mapper.PortfolioEntryDetailsMapper;
import com.example.portfolio.mapper.PortfolioEntryMapper;
import com.example.portfolio.model.PortfolioItemModel;
import com.example.portfolio.model.PortfolioItemModelDetails;
import com.example.portfolio.repository.PortfolioRepository;
import com.example.portfolio.specification.PortfolioSearchSpecification;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class PortfolioModuleImpl implements PortfolioModuleApi {
  @Autowired
  PortfolioRepository portfolioRepository;

  @Autowired
  PortfolioSearchSpecification portfolioSearchSpecification;

  @Autowired
  PortfolioEntryDetailsMapper portfolioDetailsEntryMapper;

  @Autowired
  PortfolioEntryMapper portfolioEntryMapper;

  @Override
  public Page getPortfolioEntries(PortfolioEntryDomain portfolioEntryDomain, Pageable pageable) {

    Page<PortfolioItemModel> entries =
        portfolioRepository.findAll(portfolioSearchSpecification.getEntries(portfolioEntryDomain),
            pageable);

    Page<PortfolioEntryDomain> domains =
        entries.map((domain) -> portfolioEntryMapper.modelToDomain(domain));

    return domains;
  }

  @Override
  public void savePortfolioEntry(PortfolioEntryDomain portfolioEntryDomain, PortfolioEntryDetailsDomain portfolioEntryDetailsDomain) {

    PortfolioItemModel portfolioItemModel = portfolioEntryMapper.domainToModel(portfolioEntryDomain);

    if(portfolioEntryDomain.getId() ==null){

      PortfolioItemModelDetails portfolioItemModelDetails = portfolioDetailsEntryMapper.domainToModel(portfolioEntryDetailsDomain);

      portfolioItemModel.setPortfolioItemModelDetails(portfolioItemModelDetails);

      portfolioRepository.save(portfolioItemModel);
    }

  }

  @Override
  public void deleteEntries(List<Long> ids) {

  }
}
