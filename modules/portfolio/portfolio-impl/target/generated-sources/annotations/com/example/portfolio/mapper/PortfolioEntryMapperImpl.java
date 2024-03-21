package com.example.portfolio.mapper;

import com.example.PortfolioEntryDomain;
import com.example.model.PortfolioEntryDTO;
import com.example.model.PortfolioRequestData;
import com.example.portfolio.impl.PortfolioEntryDomainImpl;
import com.example.portfolio.model.PortfolioItemModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-21T11:24:36+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class PortfolioEntryMapperImpl extends PortfolioEntryMapper {

    private final DateTimeFormatter dateTimeFormatter_dd_MM_yyyy_HH_mm_12071769242 = DateTimeFormatter.ofPattern( "dd.MM.yyyy HH:mm" );
    private final DateTimeFormatter dateTimeFormatter_yyyy_MM_dd_HH_mm_ss_11333195168 = DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm:ss" );

    @Override
    public PortfolioEntryDTO domainToRest(PortfolioEntryDomainImpl model) {
        if ( model == null ) {
            return null;
        }

        PortfolioEntryDTO portfolioEntryDTO = new PortfolioEntryDTO();

        portfolioEntryDTO.setImageUrl( model.getUrl() );
        if ( model.getModificationDate() != null ) {
            portfolioEntryDTO.setModificationDate( dateTimeFormatter_dd_MM_yyyy_HH_mm_12071769242.format( model.getModificationDate() ) );
        }
        if ( model.getCreationDate() != null ) {
            portfolioEntryDTO.setCreationDate( dateTimeFormatter_dd_MM_yyyy_HH_mm_12071769242.format( model.getCreationDate() ) );
        }
        portfolioEntryDTO.setDesignedElements( model.getProjectType() );
        portfolioEntryDTO.setLocationDetails( model.getAboutLocation() );
        portfolioEntryDTO.setId( model.getId() );
        portfolioEntryDTO.setTittle( model.getTittle() );
        portfolioEntryDTO.setWojewodztwo( model.getWojewodztwo() );
        portfolioEntryDTO.setPowiat( model.getPowiat() );
        portfolioEntryDTO.setCoatOfArmsDescription( model.getCoatOfArmsDescription() );
        portfolioEntryDTO.setSymbolsDescription( model.getSymbolsDescription() );
        portfolioEntryDTO.setHistory( model.getHistory() );
        if ( model.getCreatedAt() != null ) {
            portfolioEntryDTO.setCreatedAt( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( model.getCreatedAt() ) );
        }
        portfolioEntryDTO.setLongitude( model.getLongitude() );
        portfolioEntryDTO.setLatitude( model.getLatitude() );

        return portfolioEntryDTO;
    }

    @Override
    public PortfolioEntryDomainImpl restToDomain(PortfolioRequestData dto) {
        if ( dto == null ) {
            return null;
        }

        PortfolioEntryDomainImpl portfolioEntryDomainImpl = new PortfolioEntryDomainImpl();

        portfolioEntryDomainImpl.setProjectType( dto.getDesignedElements() );
        portfolioEntryDomainImpl.setAboutLocation( dto.getLocationDetails() );
        if ( dto.getCreatedAt() != null ) {
            portfolioEntryDomainImpl.setCreatedAt( LocalDateTime.parse( dto.getCreatedAt(), dateTimeFormatter_yyyy_MM_dd_HH_mm_ss_11333195168 ) );
        }
        portfolioEntryDomainImpl.setId( dto.getId() );
        portfolioEntryDomainImpl.setTittle( dto.getTittle() );
        portfolioEntryDomainImpl.setWojewodztwo( dto.getWojewodztwo() );
        portfolioEntryDomainImpl.setPowiat( dto.getPowiat() );
        if ( dto.getCreationDate() != null ) {
            portfolioEntryDomainImpl.setCreationDate( LocalDateTime.parse( dto.getCreationDate() ) );
        }
        if ( dto.getModificationDate() != null ) {
            portfolioEntryDomainImpl.setModificationDate( LocalDateTime.parse( dto.getModificationDate() ) );
        }
        portfolioEntryDomainImpl.setCoatOfArmsDescription( dto.getCoatOfArmsDescription() );
        portfolioEntryDomainImpl.setSymbolsDescription( dto.getSymbolsDescription() );
        portfolioEntryDomainImpl.setHistory( dto.getHistory() );
        portfolioEntryDomainImpl.setLongitude( dto.getLongitude() );
        portfolioEntryDomainImpl.setLatitude( dto.getLatitude() );

        return portfolioEntryDomainImpl;
    }

    @Override
    public PortfolioEntryDomainImpl modelToDomain(PortfolioItemModel model) {
        if ( model == null ) {
            return null;
        }

        PortfolioEntryDomainImpl portfolioEntryDomainImpl = new PortfolioEntryDomainImpl();

        portfolioEntryDomainImpl.setId( model.getId() );
        portfolioEntryDomainImpl.setTittle( model.getTittle() );
        portfolioEntryDomainImpl.setUrl( model.getUrl() );
        portfolioEntryDomainImpl.setWojewodztwo( model.getWojewodztwo() );
        portfolioEntryDomainImpl.setPowiat( model.getPowiat() );
        portfolioEntryDomainImpl.setProjectType( model.getProjectType() );
        portfolioEntryDomainImpl.setCreationDate( model.getCreationDate() );
        portfolioEntryDomainImpl.setModificationDate( model.getModificationDate() );
        portfolioEntryDomainImpl.setAboutLocation( model.getAboutLocation() );
        portfolioEntryDomainImpl.setCoatOfArmsDescription( model.getCoatOfArmsDescription() );
        portfolioEntryDomainImpl.setSymbolsDescription( model.getSymbolsDescription() );
        portfolioEntryDomainImpl.setHistory( model.getHistory() );
        portfolioEntryDomainImpl.setLongitude( model.getLongitude() );
        portfolioEntryDomainImpl.setLatitude( model.getLatitude() );
        portfolioEntryDomainImpl.setCreatedAt( model.getCreatedAt() );

        return portfolioEntryDomainImpl;
    }

    @Override
    public PortfolioItemModel domainToModel(PortfolioEntryDomain domain) {
        if ( domain == null ) {
            return null;
        }

        PortfolioItemModel portfolioItemModel = new PortfolioItemModel();

        portfolioItemModel.setId( domain.getId() );
        portfolioItemModel.setModificationDate( domain.getModificationDate() );
        portfolioItemModel.setCreationDate( domain.getCreationDate() );
        portfolioItemModel.setTittle( domain.getTittle() );
        portfolioItemModel.setWojewodztwo( domain.getWojewodztwo() );
        portfolioItemModel.setPowiat( domain.getPowiat() );
        portfolioItemModel.setProjectType( domain.getProjectType() );
        portfolioItemModel.setUrl( domain.getUrl() );
        portfolioItemModel.setAboutLocation( domain.getAboutLocation() );
        portfolioItemModel.setCoatOfArmsDescription( domain.getCoatOfArmsDescription() );
        portfolioItemModel.setSymbolsDescription( domain.getSymbolsDescription() );
        portfolioItemModel.setHistory( domain.getHistory() );
        portfolioItemModel.setCreatedAt( domain.getCreatedAt() );
        portfolioItemModel.setLongitude( domain.getLongitude() );
        portfolioItemModel.setLatitude( domain.getLatitude() );

        return portfolioItemModel;
    }

    @Override
    public PortfolioEntryDomainImpl filterRestToDomain(PortfolioRequestData portfolioRequestData) {
        if ( portfolioRequestData == null ) {
            return null;
        }

        PortfolioEntryDomainImpl portfolioEntryDomainImpl = new PortfolioEntryDomainImpl();

        portfolioEntryDomainImpl.setId( portfolioRequestData.getId() );
        portfolioEntryDomainImpl.setTittle( portfolioRequestData.getTittle() );
        portfolioEntryDomainImpl.setWojewodztwo( portfolioRequestData.getWojewodztwo() );
        portfolioEntryDomainImpl.setPowiat( portfolioRequestData.getPowiat() );
        if ( portfolioRequestData.getCreationDate() != null ) {
            portfolioEntryDomainImpl.setCreationDate( LocalDateTime.parse( portfolioRequestData.getCreationDate() ) );
        }
        if ( portfolioRequestData.getModificationDate() != null ) {
            portfolioEntryDomainImpl.setModificationDate( LocalDateTime.parse( portfolioRequestData.getModificationDate() ) );
        }
        portfolioEntryDomainImpl.setCoatOfArmsDescription( portfolioRequestData.getCoatOfArmsDescription() );
        portfolioEntryDomainImpl.setSymbolsDescription( portfolioRequestData.getSymbolsDescription() );
        portfolioEntryDomainImpl.setHistory( portfolioRequestData.getHistory() );
        portfolioEntryDomainImpl.setLongitude( portfolioRequestData.getLongitude() );
        portfolioEntryDomainImpl.setLatitude( portfolioRequestData.getLatitude() );
        if ( portfolioRequestData.getCreatedAt() != null ) {
            portfolioEntryDomainImpl.setCreatedAt( LocalDateTime.parse( portfolioRequestData.getCreatedAt() ) );
        }

        return portfolioEntryDomainImpl;
    }
}
