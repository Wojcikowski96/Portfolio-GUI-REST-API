package com.example.portfolio.mapper;

import com.example.PortfolioEntryDetailsDomain;
import com.example.model.MediaDTO;
import com.example.model.PortfolioEntryDetailsDTO;
import com.example.model.PortfolioRequestData;
import com.example.portfolio.impl.PortfolioDetails;
import com.example.portfolio.impl.PortfolioEntryDomainImpl;
import com.example.portfolio.impl.PortfolioMediaDomainImpl;
import com.example.portfolio.model.PortfolioItemModelDetails;
import java.util.ArrayList;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

@Mapper(componentModel = "spring")
public abstract class PortfolioEntryDetailsMapper {

  private static final String BASE_PREFIX = "security.template.rule";

  private static final String ATTRIBUTES_KEY_PREFIX = ".action.key.";

  private static final String ATTRIBUTES_OBJECT_PREFIX = ".object.";

  @Autowired
  private MessageSource messageSource;


  @Mappings({
//      @Mapping(source="url", target="imageUrl"),
      @Mapping(source = "locationDetails", target = "aboutLocation")})
  public abstract PortfolioDetails restToDomain(PortfolioRequestData dto);

  @Mappings({
      @Mapping(source = "aboutLocation", target = "locationDetails")})
  public abstract PortfolioEntryDetailsDTO domainToRest(PortfolioDetails domain);

  public abstract PortfolioItemModelDetails domainToModel(PortfolioEntryDetailsDomain domain);

  public abstract PortfolioDetails modelToDomain(PortfolioItemModelDetails model);

  public abstract PortfolioEntryDomainImpl filterRestToDomain(
      PortfolioRequestData portfolioRequestData);

  List<MediaDTO> generateDTOs(List<PortfolioMediaDomainImpl> models) {

    List<MediaDTO> MediaDTOS = new ArrayList<>();

    for (PortfolioMediaDomainImpl model : models) {
      MediaDTO dto = new MediaDTO();

      dto.setName(model.getName());

      dto.setUrl(model.getImageUrl());

      MediaDTOS.add(dto);
    }
    return MediaDTOS;
  }

  public void distributeMediaToDTO(List<PortfolioMediaDomainImpl> imageDomains, PortfolioEntryDetailsDTO dto) {

    List<PortfolioMediaDomainImpl> imageBody =
        imageDomains.stream().filter(x -> x.getType().equals("IMAGE_BODY")).toList();

    List<PortfolioMediaDomainImpl> imageLeftPane =
        imageDomains.stream().filter(x -> x.getType().equals("IMAGE_LEFT_PANE")).toList();

    List<PortfolioMediaDomainImpl> documents =
        imageDomains.stream().filter(x -> x.getType().equals("DOCUMENT")).toList();

    dto.setImagesUrlsPageBody(generateDTOs(imageBody));

    dto.setImagesUrlsPageLeftPane(generateDTOs(imageLeftPane));

    dto.setDocuments(generateDTOs(documents));


  }


}
