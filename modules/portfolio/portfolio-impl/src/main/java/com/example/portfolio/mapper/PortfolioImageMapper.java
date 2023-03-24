package com.example.portfolio.mapper;

import com.example.ImageDomain;
import com.example.portfolio.model.PortfolioImageModel;
import com.example.utils.ImageDomainImpl;
import com.example.utils.model.ImageModel;
import com.example.model.ImageDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

@Mapper(componentModel = "spring")
public abstract class PortfolioImageMapper {

  @Autowired
  private MessageSource messageSource;

  public abstract ImageDomainImpl modelToDomain(ImageModel model);

  public abstract PortfolioImageModel domainToModel(ImageDomain domain);


}
