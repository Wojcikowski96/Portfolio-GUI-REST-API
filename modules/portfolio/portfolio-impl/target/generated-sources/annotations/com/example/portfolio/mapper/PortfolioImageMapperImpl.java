package com.example.portfolio.mapper;

import com.example.PortfolioMediaDomain;
import com.example.portfolio.impl.PortfolioMediaDomainImpl;
import com.example.portfolio.model.PortfolioMediaModel;
import com.example.utils.enums.ExtensionType;
import com.example.utils.enums.ImageType;
import com.example.utils.model.MediaModel;
import java.util.Arrays;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-25T13:07:42+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class PortfolioImageMapperImpl extends PortfolioImageMapper {

    @Override
    public PortfolioMediaDomainImpl modelToDomain(MediaModel model) {
        if ( model == null ) {
            return null;
        }

        PortfolioMediaDomainImpl portfolioMediaDomainImpl = new PortfolioMediaDomainImpl();

        portfolioMediaDomainImpl.setId( model.getId() );
        portfolioMediaDomainImpl.setName( model.getName() );
        if ( model.getType() != null ) {
            portfolioMediaDomainImpl.setType( model.getType().name() );
        }
        byte[] image = model.getImage();
        if ( image != null ) {
            portfolioMediaDomainImpl.setImage( Arrays.copyOf( image, image.length ) );
        }
        portfolioMediaDomainImpl.setImageUrl( model.getImageUrl() );
        if ( model.getExtensionType() != null ) {
            portfolioMediaDomainImpl.setExtensionType( model.getExtensionType().name() );
        }

        return portfolioMediaDomainImpl;
    }

    @Override
    public PortfolioMediaModel domainToModel(PortfolioMediaDomain domain) {
        if ( domain == null ) {
            return null;
        }

        PortfolioMediaModel portfolioMediaModel = new PortfolioMediaModel();

        portfolioMediaModel.setId( domain.getId() );
        portfolioMediaModel.setName( domain.getName() );
        if ( domain.getType() != null ) {
            portfolioMediaModel.setType( Enum.valueOf( ImageType.class, domain.getType() ) );
        }
        byte[] image = domain.getImage();
        if ( image != null ) {
            portfolioMediaModel.setImage( Arrays.copyOf( image, image.length ) );
        }
        portfolioMediaModel.setImageUrl( domain.getImageUrl() );
        if ( domain.getExtensionType() != null ) {
            portfolioMediaModel.setExtensionType( Enum.valueOf( ExtensionType.class, domain.getExtensionType() ) );
        }

        return portfolioMediaModel;
    }
}
