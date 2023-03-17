package com.example.mapper;

import com.example.model.EmailDTO;
import com.example.impl.EmailDomainApiImpl;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class EmailMapper {

  public abstract EmailDTO domainToRest(EmailDomainApiImpl domain);

  public abstract EmailDomainApiImpl restToDomain(EmailDTO dto);
}
