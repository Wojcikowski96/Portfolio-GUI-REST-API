package com.example.blog.mapper;

import com.example.BlogEntryDomain;
import com.example.blog.impl.BlogEntryDomainImpl;
import com.example.blog.model.BlogEntryModel;

import com.example.model.BlogEntryDTO;
import com.example.model.RequestData;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public abstract class BlogEntryMapper {

  private static final String BASE_PREFIX = "security.template.rule";

  private static final String ATTRIBUTES_KEY_PREFIX = ".action.key.";

  private static final String ATTRIBUTES_OBJECT_PREFIX = ".object.";

  @Autowired
  private MessageSource messageSource;

  public abstract BlogEntryDTO domainToRest(BlogEntryDomainImpl model);

  public abstract BlogEntryDomainImpl restToDomain(BlogEntryDTO dto);

  public abstract BlogEntryDomainImpl modelToDomain(BlogEntryModel model);

  public abstract BlogEntryModel domainToModel(BlogEntryDomain domain);

  public abstract BlogEntryDomainImpl filterRestToDomain(RequestData requestData);


}