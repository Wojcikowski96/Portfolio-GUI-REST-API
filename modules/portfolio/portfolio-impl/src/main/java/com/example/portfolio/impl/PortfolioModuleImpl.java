package com.example.portfolio.impl;

import com.example.ImageDomain;
import com.example.PortfolioEntryDetailsDomain;
import com.example.PortfolioEntryDomain;
import com.example.PortfolioModuleApi;
import com.example.portfolio.mapper.PortfolioEntryDetailsMapper;
import com.example.portfolio.mapper.PortfolioEntryMapper;
import com.example.portfolio.model.PortfolioImageModel;
import com.example.portfolio.model.PortfolioItemModel;
import com.example.portfolio.model.PortfolioItemModelDetails;
import com.example.portfolio.repository.PortfolioImageRepository;
import com.example.portfolio.repository.PortfolioRepository;
import com.example.portfolio.specification.PortfolioSearchSpecification;
import com.example.utils.Utils;
import com.example.portfolio.mapper.PortfolioImageMapper;
import com.example.utils.repository.ImagesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class PortfolioModuleImpl implements PortfolioModuleApi {
  @Autowired
  PortfolioRepository portfolioRepository;

  @Autowired
  PortfolioImageRepository imagesRepository;

  @Autowired
  PortfolioImageMapper portfolioImageMapper;

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

    PortfolioItemModelDetails portfolioItemModelDetails = portfolioDetailsEntryMapper.domainToModel(portfolioEntryDetailsDomain);

    portfolioItemModel.setPortfolioItemModelDetails(portfolioItemModelDetails);

    if(portfolioEntryDomain.getId() == null){

      portfolioRepository.save(portfolioItemModel);

    }else{

      Optional<PortfolioItemModel> portfolioItemModelOptional = portfolioRepository.findById(portfolioEntryDomain.getId());

      PortfolioItemModel merged = Utils.updater(portfolioItemModelOptional.get(), portfolioItemModel);

      portfolioRepository.save(merged);

    }

  }

  @Override
  public void deleteEntries(List<Long> ids) {

  }

  @Override
  public void uploadImage(ImageDomain imageDomain, Long entryId) {

     Optional<PortfolioItemModel> portfolioItemModelOptional = portfolioRepository.findById(entryId);

     PortfolioImageModel imageModel = portfolioImageMapper.domainToModel(imageDomain);

     if(imageDomain.getId() == null){

       imageModel.setPortfolioItemModelDetails(portfolioItemModelOptional.get()
           .getPortfolioItemModelDetails());

       imagesRepository.save(portfolioImageMapper.domainToModel(imageDomain));

     }
  }
}
