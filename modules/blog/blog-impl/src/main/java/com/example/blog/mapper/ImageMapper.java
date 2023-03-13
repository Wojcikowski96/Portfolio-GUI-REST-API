package com.example.blog.mapper;

import com.example.BlogEntryDomain;
import com.example.ImageDomain;
import com.example.blog.impl.BlogEntryDomainImpl;
import com.example.blog.impl.ImageDomainImpl;
import com.example.blog.model.BlogEntryModel;
import com.example.blog.model.ImageModel;
import com.example.model.BlogEntryDTO;
import com.example.model.ImageDTO;
import com.example.model.RequestData;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

@Mapper(componentModel = "spring")
public abstract class ImageMapper {

  @Autowired
  private MessageSource messageSource;

  public abstract ImageDTO domainToRest(ImageDomainImpl model);

  public abstract ImageDomainImpl restToDomain(ImageDTO dto);

  public abstract ImageDomainImpl modelToDomain(ImageModel model);

  public abstract ImageModel domainToModel(ImageDomain domain);


}
