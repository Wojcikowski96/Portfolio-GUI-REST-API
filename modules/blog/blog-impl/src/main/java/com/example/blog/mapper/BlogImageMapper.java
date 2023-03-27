package com.example.blog.mapper;

import com.example.BlogImageDomain;
import com.example.blog.model.BlogImageModel;
//import com.example.model.ImageDTO;
import com.example.blog.impl.BlogImageDomainImpl;
import com.example.utils.model.ImageModel;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

@Mapper(componentModel = "spring")
public abstract class BlogImageMapper {

  @Autowired
  private MessageSource messageSource;

//  public abstract ImageDTO domainToRest(ImageDomainImpl model);
//
//  public abstract ImageDomainImpl restToDomain(ImageDTO dto);

  public abstract BlogImageDomainImpl modelToDomain(ImageModel model);

  public abstract BlogImageModel domainToModel(BlogImageDomain domain);


}
