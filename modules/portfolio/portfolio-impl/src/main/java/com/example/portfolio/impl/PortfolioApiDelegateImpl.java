package com.example.portfolio.impl;

import com.example.PortfolioApi;
import com.example.PortfolioApiDelegate;
import com.example.PortfolioModuleApi;
import com.example.model.GetPortfolioEntries200Response;
import com.example.model.PortfolioEntryDTO;
import com.example.model.PortfolioRequestData;
import com.example.portfolio.mapper.PortfolioEntryDetailsMapper;
import com.example.portfolio.mapper.PortfolioEntryMapper;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

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
}
