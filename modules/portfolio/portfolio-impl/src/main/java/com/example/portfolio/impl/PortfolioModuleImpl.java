package com.example.portfolio.impl;

import com.example.PortfolioEntryDomain;
import com.example.PortfolioMediaDomain;
import com.example.PortfolioModuleApi;
import com.example.portfolio.mapper.PortfolioEntryMapper;
import com.example.portfolio.model.PortfolioMediaModel;
import com.example.portfolio.model.PortfolioItemModel;
import com.example.portfolio.repository.PortfolioImageRepository;
import com.example.portfolio.repository.PortfolioRepository;
import com.example.portfolio.specification.PortfolioSearchSpecification;

import com.example.utils.Utils;
import com.example.portfolio.mapper.PortfolioImageMapper;
import com.example.utils.exception.ExceptionsFactory;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class PortfolioModuleImpl implements PortfolioModuleApi {
  @Autowired
  PortfolioRepository portfolioRepository;

  @Autowired
  PortfolioImageRepository mediaRepository;

  @Autowired
  PortfolioImageMapper portfolioImageMapper;

  @Autowired
  PortfolioSearchSpecification portfolioSearchSpecification;

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
  public void savePortfolioEntry(PortfolioEntryDomain portfolioEntryDomain) {

    PortfolioItemModel portfolioItemModel =
        portfolioEntryMapper.domainToModel(portfolioEntryDomain);

    if (portfolioEntryDomain.getId() == null) {

      portfolioRepository.save(portfolioItemModel);

    } else {

      Optional<PortfolioItemModel> portfolioItemModelOptional = Optional.ofNullable(
          portfolioRepository.findById(portfolioEntryDomain.getId()).orElseThrow(
              () -> ExceptionsFactory.createNotFound(
                  "Nie znaleziono wpisu portfolio o id: " + portfolioEntryDomain.getId(), "NZWP",
                  null)));


      PortfolioItemModel mergedMainItem =
          Utils.updater(portfolioItemModelOptional.get(), portfolioItemModel);

      portfolioRepository.save(mergedMainItem);

    }

  }

  @Override
  public void deleteEntries(List<Long> ids) {
    for(Long id : ids){
      List<PortfolioMediaDomainImpl> medias = getPortfolioMediaModels(id);
      for(PortfolioMediaDomainImpl media : medias){
        mediaRepository.deleteById(media.getId());
      }
      portfolioRepository.deleteById(id);
    }

  }

  @Override
  public void deleteImage(Long imageId) {
    mediaRepository.deleteById(imageId);
  }

  @Override
  public void uploadFile(PortfolioMediaDomain portfolioMediaDomain, Long entryId) {

    PortfolioMediaModel mediaModel = portfolioImageMapper.domainToModel(portfolioMediaDomain);
    try {
      List<PortfolioMediaDomainImpl> imagesList =
          getPortfolioMediaModels(entryId);

      Optional<PortfolioItemModel> portfolioOptional = Optional.ofNullable(
          portfolioRepository.findById(entryId).orElseThrow(
              () -> ExceptionsFactory.createNotFound(
                  "Nie znaleziono wpisu portfolio o id: " + entryId, "NZWP", null)));

      PortfolioMediaDomainImpl portfolioMediaDomainByName = imagesList.stream()
          .filter(o -> o.getName().equals(portfolioMediaDomain.getName()))
          .findFirst()
          .orElse(null);

      if (portfolioMediaDomainByName != null) {

        Optional<PortfolioMediaModel> potfolioMediaModelOptional =
            mediaRepository.findById(portfolioMediaDomainByName.getId());

        PortfolioMediaModel mergedMediaModel =
            Utils.updater(potfolioMediaModelOptional.get(), mediaModel);

        mergedMediaModel.setImage(mediaModel.getImage());

        mediaRepository.save(mergedMediaModel);

      } else {
        mediaModel.setPortfolioItemModel(portfolioOptional.get());

        mediaModel.setImageUrl(Utils.generateFileUrl(entryId, portfolioMediaDomain.getName()));

        mediaRepository.save(mediaModel);
      }
      if (portfolioMediaDomain.getName().equals("Herb")) {

        PortfolioItemModel portfolioItemModelToChangeUrl = portfolioOptional.get();

        portfolioItemModelToChangeUrl.setUrl(
            Utils.generateFileUrl(entryId, portfolioMediaDomain.getName()));

        portfolioRepository.save(portfolioItemModelToChangeUrl);

      }

    } catch (IllegalArgumentException e) {
      throw ExceptionsFactory.createInternalServerError(
          "Brak zdefiniowanego typu obrazka " + portfolioMediaDomain.getType(), "BZTO", null);
    }
  }


  @Override
  public byte[] getMedia(Long entryId, String name) {

    List<PortfolioMediaDomainImpl> imagesList =
        getPortfolioMediaModels(entryId);

    Optional<PortfolioMediaDomainImpl> model =
        imagesList.stream().filter(p -> p.getName().equals(name)).findFirst();

    if (!model.isPresent()) {
      throw ExceptionsFactory.createConflict("Nie znaleziono zasobu " + name,
          "NZS", null);
    }

    return model.get().getImage();

  }

  @Override
  public List<PortfolioMediaDomainImpl> getPortfolioMediaModels(Long entryId) {

    Optional<List<PortfolioMediaModel>> imagesList = Optional.ofNullable(
        mediaRepository.findByPortfolioItemModelId(entryId).orElseThrow(
            () -> ExceptionsFactory.createNotFound(
                "Nie znaleziono plików dla wpisu o id: " + entryId, "NZPDW", null)));


    List<PortfolioMediaModel> models = imagesList.get();

    List<PortfolioMediaDomainImpl>
        imageDomains = models.stream().map(x -> portfolioImageMapper.modelToDomain(x)).toList();

    return imageDomains;
  }

}
