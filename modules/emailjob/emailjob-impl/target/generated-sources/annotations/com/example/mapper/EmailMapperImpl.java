package com.example.mapper;

import com.example.impl.EmailDomainApiImpl;
import com.example.model.EmailDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-21T11:24:51+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class EmailMapperImpl extends EmailMapper {

    @Override
    public EmailDTO domainToRest(EmailDomainApiImpl domain) {
        if ( domain == null ) {
            return null;
        }

        EmailDTO emailDTO = new EmailDTO();

        emailDTO.setNick( domain.getNick() );
        emailDTO.setEmail( domain.getEmail() );
        emailDTO.setTittle( domain.getTittle() );
        emailDTO.setContent( domain.getContent() );

        return emailDTO;
    }

    @Override
    public EmailDomainApiImpl restToDomain(EmailDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EmailDomainApiImpl emailDomainApiImpl = new EmailDomainApiImpl();

        emailDomainApiImpl.setTittle( dto.getTittle() );
        emailDomainApiImpl.setContent( dto.getContent() );
        emailDomainApiImpl.setEmail( dto.getEmail() );
        emailDomainApiImpl.setNick( dto.getNick() );

        return emailDomainApiImpl;
    }
}
