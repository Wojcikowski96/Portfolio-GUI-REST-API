package com.example.portfolio.mapper;

import com.example.PortfolioEntryDetailsDomain;
import com.example.PortfolioEntryDomain;
import com.example.model.PortfolioEntryDTO;
import com.example.model.PortfolioRequestData;
import com.example.portfolio.impl.PortfolioDetails;
import com.example.portfolio.impl.PortfolioEntryDomainImpl;
import com.example.portfolio.model.PortfolioItemModel;
import com.example.portfolio.model.PortfolioItemModelDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

@Mapper(componentModel = "spring")
public abstract class PortfolioEntryDetailsMapper {

  private static final String BASE_PREFIX = "security.template.rule";

  private static final String ATTRIBUTES_KEY_PREFIX = ".action.key.";

  private static final String ATTRIBUTES_OBJECT_PREFIX = ".object.";

  @Autowired
  private MessageSource messageSource;


  @Mappings({
//      @Mapping(source="url", target="imageUrl"),
      @Mapping(source = "locationDetails", target="aboutLocation"),
      @Mapping(source = "otherSymbolsDescription", target = "symbolsDescription")})
  public abstract PortfolioDetails restToDomain(PortfolioRequestData dto);

  public abstract PortfolioItemModelDetails domainToModel(PortfolioEntryDetailsDomain domain);

  public abstract PortfolioEntryDomainImpl filterRestToDomain(
      PortfolioRequestData portfolioRequestData);
}
