package com.example.portfolio.impl;

import com.example.PortfolioApiDelegate;
import com.example.PortfolioModuleApi;
import com.example.model.GetPortfolioEntries200Response;
import com.example.model.PortfolioRequestData;
import com.example.portfolio.mapper.PortfolioEntryMapper;
import com.example.portfolio.repository.PortfolioRepository;
import java.io.IOException;
import java.util.List;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

@Component
public class PortfolioApiDelegateImpl implements PortfolioApiDelegate {

  @Autowired
  PortfolioModuleApi portfolioModuleApi;

  @Autowired
  PortfolioEntryMapper portfolioEntryMapper;

  @Autowired
  PortfolioRepository portfolioRepository;

  @Override
  @CrossOrigin("http://localhost:4200")
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
            .map(entry -> {
              portfolioEntryMapper.distributeMediaToDTO(portfolioModuleApi.getPortfolioMediaModels(entry.getId()), entry);
              return entry;
            })
            .collect(
                Collectors.toList()));

    return ResponseEntity.ok(response);
  }

  @Override
  public ResponseEntity<Void> savePortfolioEntry(PortfolioRequestData portfolioRequestData) {


    portfolioModuleApi.savePortfolioEntry(portfolioEntryMapper.restToDomain(portfolioRequestData));

    return ResponseEntity.noContent().build();
  }


  @Override
  public ResponseEntity<Void> uploadFileToPortfolio(Long entryId, String name, String type, String extensionType,
                                                     MultipartFile fileByteString) {

    PortfolioMediaDomainImpl mediaDomain = new PortfolioMediaDomainImpl();

    mediaDomain.setName(name);

    mediaDomain.setType(type);

    mediaDomain.setExtensionType(extensionType);

    try {
      mediaDomain.setImage(fileByteString.getBytes());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    portfolioModuleApi.uploadFile(mediaDomain, entryId);

    return ResponseEntity.noContent().build();
  }


  @Override
  public ResponseEntity<Resource> getImageOrPdfForPortfolioDetails(Long entryId, String imageName) {

    byte [] imageData = portfolioModuleApi.getMedia(entryId, imageName);

    Resource res = new ByteArrayResource(imageData);

    return ResponseEntity.status(HttpStatus.OK).body(res);

  }

  @Override
  public ResponseEntity<Void> deleteFile(Long imageId) {

    portfolioModuleApi.deleteImage(imageId);

    return ResponseEntity.noContent().build();
  }


  @Override
  public ResponseEntity<Void> deletePortfolioEntries(List<Long> entryId) {

    portfolioModuleApi.deleteEntries(entryId);

    return ResponseEntity.noContent().build();
  }
}
