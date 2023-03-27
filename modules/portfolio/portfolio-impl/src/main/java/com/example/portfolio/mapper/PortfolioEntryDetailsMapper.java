package com.example.portfolio.mapper;

import com.example.PortfolioEntryDetailsDomain;
import com.example.model.ImageDTO;
import com.example.model.PortfolioEntryDetailsDTO;
import com.example.model.PortfolioRequestData;
import com.example.portfolio.impl.PortfolioDetails;
import com.example.portfolio.impl.PortfolioEntryDomainImpl;
import com.example.portfolio.impl.PortfolioImageDomainImpl;
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

  List<ImageDTO> generateDTOs(List<PortfolioImageDomainImpl> models) {

    List<ImageDTO> imageDTOS = new ArrayList<>();

    for (PortfolioImageDomainImpl model : models) {
      ImageDTO dto = new ImageDTO();

      dto.setName(model.getName());

      dto.setUrl(model.getImageUrl());

      imageDTOS.add(dto);
    }
    return imageDTOS;
  }

  public void distributeImagesToDTO(List<PortfolioImageDomainImpl> imageDomains, PortfolioEntryDetailsDTO dto) {

    List<PortfolioImageDomainImpl> body =
        imageDomains.stream().filter(x -> x.getType().equals("BODY")).toList();

    List<PortfolioImageDomainImpl> leftPane =
        imageDomains.stream().filter(x -> x.getType().equals("LEFT_PANE")).toList();

    dto.setImagesUrlsPageBody(generateDTOs(body));

    dto.setImagesUrlsPageLeftPane(generateDTOs(leftPane));


  }


}
