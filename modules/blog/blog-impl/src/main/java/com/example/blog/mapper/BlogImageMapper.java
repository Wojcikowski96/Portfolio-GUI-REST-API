package com.example.blog.mapper;

import com.example.ImageDomain;
import com.example.blog.model.BlogImageModel;
import com.example.model.ImageDTO;
import com.example.utils.ImageDomainImpl;
import com.example.utils.model.ImageModel;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

@Mapper(componentModel = "spring")
public abstract class BlogImageMapper {

  @Autowired
  private MessageSource messageSource;

  public abstract ImageDTO domainToRest(ImageDomainImpl model);

  public abstract ImageDomainImpl restToDomain(ImageDTO dto);

  public abstract ImageDomainImpl modelToDomain(ImageModel model);

  public abstract BlogImageModel domainToModel(ImageDomain domain);


}
