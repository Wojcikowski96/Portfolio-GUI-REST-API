package com.example.portfolio.mapper;

import com.example.BlogEntryDomain;
import com.example.PortfolioEntryDomain;
import com.example.blog.impl.BlogEntryDomainImpl;
import com.example.blog.model.BlogEntryModel;
import com.example.model.BlogEntryDTO;
import com.example.model.BlogRequestData;
import com.example.model.PortfolioEntryDTO;
import com.example.model.PortfolioRequestData;
import com.example.portfolio.impl.PortfolioEntryDomainImpl;
import com.example.portfolio.model.PortfolioItemModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

@Mapper(componentModel = "spring")
public abstract class PortfolioEntryMapper {
  private static final String BASE_PREFIX = "security.template.rule";

  private static final String ATTRIBUTES_KEY_PREFIX = ".action.key.";

  private static final String ATTRIBUTES_OBJECT_PREFIX = ".object.";

  @Autowired
  private MessageSource messageSource;

  @Mappings({@Mapping(source="url", target="imageUrl"),
      @Mapping(source = "modificationDate", target="modificationDate", dateFormat = "dd.MM.yyyy HH:mm"),
      @Mapping(source = "creationDate", target = "creationDate", dateFormat = "dd.MM.yyyy HH:mm"),
      @Mapping(source = "projectType", target = "designedElements", dateFormat = "dd.MM.yyyy HH:mm")})
  public abstract PortfolioEntryDTO domainToRest(PortfolioEntryDomainImpl model);

  @Mappings({@Mapping(source="designedElements", target="projectType")})
  public abstract PortfolioEntryDomainImpl restToDomain(PortfolioRequestData dto);

//  @Mapping(source="image.imageUrl", target="url")
  public abstract PortfolioEntryDomainImpl modelToDomain(PortfolioItemModel model);

  public abstract PortfolioItemModel domainToModel(PortfolioEntryDomain domain);

  public abstract PortfolioEntryDomainImpl filterRestToDomain(
      PortfolioRequestData portfolioRequestData);
}
