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
import com.example.portfolio.repository.PortfolioDetailsRepository;
import com.example.portfolio.repository.PortfolioImageRepository;
import com.example.portfolio.repository.PortfolioRepository;
import com.example.portfolio.specification.PortfolioSearchSpecification;
import com.example.utils.ImageDomainImpl;
import com.example.utils.Utils;
import com.example.portfolio.mapper.PortfolioImageMapper;
import com.example.utils.exception.ExceptionsFactory;
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
  PortfolioDetailsRepository portfolioDetailsRepository;

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
  public PortfolioEntryDetailsDomain getPortfolioEntryDetails(Long id) {

    return portfolioDetailsEntryMapper.modelToDomain(portfolioDetailsRepository.findById(id).get());
  }

  @Override
  public void savePortfolioEntry(PortfolioEntryDomain portfolioEntryDomain,
                                 PortfolioEntryDetailsDomain portfolioEntryDetailsDomain) {

    PortfolioItemModel portfolioItemModel =
        portfolioEntryMapper.domainToModel(portfolioEntryDomain);

    PortfolioItemModelDetails portfolioItemModelDetails =
        portfolioDetailsEntryMapper.domainToModel(portfolioEntryDetailsDomain);

    portfolioItemModel.setPortfolioItemModelDetails(portfolioItemModelDetails);

    if (portfolioEntryDomain.getId() == null) {

      portfolioRepository.save(portfolioItemModel);

    } else {

      Optional<PortfolioItemModel> portfolioItemModelOptional =
          portfolioRepository.findById(portfolioEntryDomain.getId());

      PortfolioItemModel merged =
          Utils.updater(portfolioItemModelOptional.get(), portfolioItemModel);

      portfolioRepository.save(merged);

    }

  }

  @Override
  public void deleteEntries(List<Long> ids) {

  }

  @Override
  public void uploadImage(ImageDomain imageDomain, Long entryId) {

    Optional<PortfolioItemModelDetails> portfolioItemModelOptional =
        portfolioDetailsRepository.findById(entryId);

    List<ImageDomainImpl> imagesList =
        getPortfolioImageModels(entryId);

    if (imagesList.stream().anyMatch(o -> o.getName().equals(imageDomain.getName()))) {
      throw ExceptionsFactory.createInternalServerError(
          "Nazwy obrazków per wpis nie mogą się powtarzać", "NOPWNSP", null);
    }

    try {
      PortfolioImageModel imageModel = portfolioImageMapper.domainToModel(imageDomain);

      if (imageDomain.getId() == null) {

        imageModel.setPortfolioItemModelDetails(portfolioItemModelOptional.get());

        imageModel.setImageUrl(Utils.generateImageUrl(entryId, imageDomain.getName()));

        imagesRepository.save(imageModel);

      }
    } catch (IllegalArgumentException e) {
      throw ExceptionsFactory.createInternalServerError(
          "Brak zdefiniowanego typu obrazka " + imageDomain.getType(), "BZTO", null);
    }
  }

  @Override
  public byte[] getImage(Long entryId, String name) {

    List<ImageDomainImpl> imagesList =
        getPortfolioImageModels(entryId);

    Optional<ImageDomainImpl> model =
        imagesList.stream().filter(p -> p.getName().equals(name)).findFirst();

    if (!model.isPresent()) {
      ExceptionsFactory.createConflict("Nie znaleziono obrazka dla wpisu o nazwie " + name,
          "NODWON", null);
    }

    return model.get().getImage();

  }
@Override
  public List<ImageDomainImpl> getPortfolioImageModels(Long entryId) {
    Optional<List<PortfolioImageModel>> imagesList =
        imagesRepository.findByPortfolioItemModelDetailsId(entryId);

    List<PortfolioImageModel> models = imagesList.get();

    List<ImageDomainImpl>
        imageDomains = models.stream().map(x->portfolioImageMapper.modelToDomain(x)).toList();

    return imageDomains;
  }

}
