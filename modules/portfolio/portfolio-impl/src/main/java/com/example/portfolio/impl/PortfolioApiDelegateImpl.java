package com.example.portfolio.impl;

import com.example.PortfolioApiDelegate;
import com.example.PortfolioModuleApi;
import com.example.model.GetPortfolioEntries200Response;
import com.example.model.PortfolioEntryDetailsDTO;
import com.example.model.PortfolioRequestData;
import com.example.portfolio.mapper.PortfolioEntryDetailsMapper;
import com.example.portfolio.mapper.PortfolioEntryMapper;
import com.example.utils.ImageDomainImpl;
import java.io.IOException;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class PortfolioApiDelegateImpl implements PortfolioApiDelegate {

  @Autowired
  PortfolioModuleApi portfolioModuleApi;

  @Autowired
  PortfolioEntryMapper portfolioEntryMapper;

  @Autowired
  PortfolioEntryDetailsMapper portfolioEntryDetailsMapper;

  @Override
  public ResponseEntity<GetPortfolioEntries200Response> getPortfolioEntries(
      PortfolioRequestData portfolioRequestData) {

    Sort sort = Sort.by(Sort.Direction.valueOf(portfolioRequestData.getSortDir().getValue()),
        portfolioRequestData.getSortBy());

    Pageable pageable =
        PageRequest.of(portfolioRequestData.getPageNo() - 1, portfolioRequestData.getPageSize(),
            sort);

    Page<PortfolioEntryDomainImpl> PortfolioEntryDomainPage =
        portfolioModuleApi.getPortfolioEntries(
            portfolioEntryMapper.filterRestToDomain(portfolioRequestData), pageable);

    GetPortfolioEntries200Response response = new GetPortfolioEntries200Response();

    response.setPageNo(portfolioRequestData.getPageNo());
    response.setPageSize(portfolioRequestData.getPageSize());
    response.setTotalElements(PortfolioEntryDomainPage.getTotalElements());
    response.setTotalPages(PortfolioEntryDomainPage.getTotalPages());

    response.setResults(
        PortfolioEntryDomainPage.getContent().stream()
            .map(log -> portfolioEntryMapper.domainToRest(log))
            .collect(
                Collectors.toList()));

    return ResponseEntity.ok(response);
  }

  @Override
  public ResponseEntity<Void> savePortfolioEntry(PortfolioRequestData portfolioRequestData) {


    portfolioModuleApi.savePortfolioEntry(portfolioEntryMapper.restToDomain(portfolioRequestData),
        portfolioEntryDetailsMapper.restToDomain(portfolioRequestData));


    return ResponseEntity.noContent().build();
  }

  @Override
  public ResponseEntity<Void> uploadImageToPortfolio(Long entryId, String name, String type,
                                                     MultipartFile fileByteString) {

    ImageDomainImpl imageDomain = new ImageDomainImpl();

    imageDomain.setName(name);

    imageDomain.setType(type);

    try {
      imageDomain.setImage(fileByteString.getBytes());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    portfolioModuleApi.uploadImage(imageDomain, entryId);

    return ResponseEntity.noContent().build();
  }

  @Override
  public ResponseEntity<Resource> getImageForPortfolioDetails(Long entryId, String imageName) {

    byte [] imageData = portfolioModuleApi.getImage(entryId, imageName);

    Resource res = new ByteArrayResource(imageData);

    return ResponseEntity.status(HttpStatus.OK).body(res);
  }

  @Override
  public ResponseEntity<PortfolioEntryDetailsDTO> getPortfolioDetails(Long entryId) {

    PortfolioEntryDetailsDTO portfolioEntryDetailsDTO = portfolioEntryDetailsMapper.domainToRest(
        (PortfolioDetails) portfolioModuleApi.getPortfolioEntryDetails(entryId));


    portfolioEntryDetailsMapper.distributeImagesToDTO(portfolioModuleApi.getPortfolioImageModels(entryId), portfolioEntryDetailsDTO);

    return ResponseEntity.ok(portfolioEntryDetailsDTO);
  }
}
