//package com.example.blog.mapper;
//
//import net.atos.mit.security.SecurityTemplate;
//import net.atos.mit.security.impl.SecurityTemplateImpl;
//import net.atos.mit.security.model.SecurityTemplateModel;
//import net.atos.model.RequestData;
//import net.atos.model.SecurityTemplateDTO;
//import org.mapstruct.Mapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//
//@Mapper
//public abstract class BlogCommentMapper {
//
//  @Autowired
//  private MessageSource messageSource;
//
//  public abstract SecurityTemplateDTO domainToRest(SecurityTemplateImpl model);
//
//  public abstract SecurityTemplateImpl restToDomain(SecurityTemplateDTO securityTemplateDTO);
//
//  public abstract SecurityTemplateImpl modelToDomain(SecurityTemplateModel model);
//
//  public abstract SecurityTemplateImpl filterRestToDomain(RequestData requestData);
//
//  public abstract SecurityTemplateModel domainToModel(SecurityTemplate securityTemplate);
//
//
//}
