package com.example.portfolio.mapper;

import com.example.BlogImageDomain;
import com.example.PortfolioImageDomain;
import com.example.portfolio.impl.PortfolioImageDomainImpl;
import com.example.portfolio.model.PortfolioImageModel;
import com.example.utils.model.ImageModel;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

@Mapper(componentModel = "spring")
public abstract class PortfolioImageMapper {

  @Autowired
  private MessageSource messageSource;

  public abstract PortfolioImageDomainImpl modelToDomain(ImageModel model);

  public abstract PortfolioImageModel domainToModel(PortfolioImageDomain domain);


}
