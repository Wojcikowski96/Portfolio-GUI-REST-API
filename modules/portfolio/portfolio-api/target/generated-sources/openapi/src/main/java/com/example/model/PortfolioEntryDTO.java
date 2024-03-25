package com.example.model;

import java.net.URI;
import java.util.Objects;
import com.example.model.MediaDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * PortfolioEntryDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-25T13:07:24.953409300+01:00[Europe/Warsaw]")
public class PortfolioEntryDTO {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("tittle")
  private String tittle;

  @JsonProperty("modificationDate")
  private String modificationDate;

  @JsonProperty("creationDate")
  private String creationDate;

  @JsonProperty("designedElements")
  private String designedElements;

  @JsonProperty("imageUrl")
  private String imageUrl;

  @JsonProperty("wojewodztwo")
  private String wojewodztwo;

  @JsonProperty("powiat")
  private String powiat;

  @JsonProperty("locationDetails")
  private String locationDetails;

  @JsonProperty("coatOfArmsDescription")
  private String coatOfArmsDescription;

  @JsonProperty("imagesUrlsPageBody")
  @Valid
  private List<MediaDTO> imagesUrlsPageBody = null;

  @JsonProperty("symbolsDescription")
  private String symbolsDescription;

  @JsonProperty("history")
  private String history;

  @JsonProperty("imagesUrlsPageLeftPane")
  @Valid
  private List<MediaDTO> imagesUrlsPageLeftPane = null;

  @JsonProperty("documents")
  @Valid
  private List<MediaDTO> documents = null;

  @JsonProperty("createdAt")
  private String createdAt;

  @JsonProperty("longitude")
  private Double longitude = null;

  @JsonProperty("latitude")
  private Double latitude = null;

  public PortfolioEntryDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", required = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PortfolioEntryDTO tittle(String tittle) {
    this.tittle = tittle;
    return this;
  }

  /**
   * Get tittle
   * @return tittle
  */
  
  @Schema(name = "tittle", required = false)
  public String getTittle() {
    return tittle;
  }

  public void setTittle(String tittle) {
    this.tittle = tittle;
  }

  public PortfolioEntryDTO modificationDate(String modificationDate) {
    this.modificationDate = modificationDate;
    return this;
  }

  /**
   * Get modificationDate
   * @return modificationDate
  */
  @Pattern(regexp = "/([0-9]{2}).(?:[0-9]{2}).([0-9]{4}) (?:[0-9]{2}):(?:[0-9]{2})/") 
  @Schema(name = "modificationDate", required = false)
  public String getModificationDate() {
    return modificationDate;
  }

  public void setModificationDate(String modificationDate) {
    this.modificationDate = modificationDate;
  }

  public PortfolioEntryDTO creationDate(String creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * Get creationDate
   * @return creationDate
  */
  @Pattern(regexp = "/([0-9]{2}).(?:[0-9]{2}).([0-9]{4}) (?:[0-9]{2}):(?:[0-9]{2})/") 
  @Schema(name = "creationDate", required = false)
  public String getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }

  public PortfolioEntryDTO designedElements(String designedElements) {
    this.designedElements = designedElements;
    return this;
  }

  /**
   * Get designedElements
   * @return designedElements
  */
  
  @Schema(name = "designedElements", required = false)
  public String getDesignedElements() {
    return designedElements;
  }

  public void setDesignedElements(String designedElements) {
    this.designedElements = designedElements;
  }

  public PortfolioEntryDTO imageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

  /**
   * Get imageUrl
   * @return imageUrl
  */
  
  @Schema(name = "imageUrl", required = false)
  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public PortfolioEntryDTO wojewodztwo(String wojewodztwo) {
    this.wojewodztwo = wojewodztwo;
    return this;
  }

  /**
   * Get wojewodztwo
   * @return wojewodztwo
  */
  
  @Schema(name = "wojewodztwo", required = false)
  public String getWojewodztwo() {
    return wojewodztwo;
  }

  public void setWojewodztwo(String wojewodztwo) {
    this.wojewodztwo = wojewodztwo;
  }

  public PortfolioEntryDTO powiat(String powiat) {
    this.powiat = powiat;
    return this;
  }

  /**
   * Get powiat
   * @return powiat
  */
  
  @Schema(name = "powiat", required = false)
  public String getPowiat() {
    return powiat;
  }

  public void setPowiat(String powiat) {
    this.powiat = powiat;
  }

  public PortfolioEntryDTO locationDetails(String locationDetails) {
    this.locationDetails = locationDetails;
    return this;
  }

  /**
   * Get locationDetails
   * @return locationDetails
  */
  
  @Schema(name = "locationDetails", required = false)
  public String getLocationDetails() {
    return locationDetails;
  }

  public void setLocationDetails(String locationDetails) {
    this.locationDetails = locationDetails;
  }

  public PortfolioEntryDTO coatOfArmsDescription(String coatOfArmsDescription) {
    this.coatOfArmsDescription = coatOfArmsDescription;
    return this;
  }

  /**
   * Get coatOfArmsDescription
   * @return coatOfArmsDescription
  */
  
  @Schema(name = "coatOfArmsDescription", required = false)
  public String getCoatOfArmsDescription() {
    return coatOfArmsDescription;
  }

  public void setCoatOfArmsDescription(String coatOfArmsDescription) {
    this.coatOfArmsDescription = coatOfArmsDescription;
  }

  public PortfolioEntryDTO imagesUrlsPageBody(List<MediaDTO> imagesUrlsPageBody) {
    this.imagesUrlsPageBody = imagesUrlsPageBody;
    return this;
  }

  public PortfolioEntryDTO addImagesUrlsPageBodyItem(MediaDTO imagesUrlsPageBodyItem) {
    if (this.imagesUrlsPageBody == null) {
      this.imagesUrlsPageBody = new ArrayList<>();
    }
    this.imagesUrlsPageBody.add(imagesUrlsPageBodyItem);
    return this;
  }

  /**
   * Get imagesUrlsPageBody
   * @return imagesUrlsPageBody
  */
  @Valid 
  @Schema(name = "imagesUrlsPageBody", required = false)
  public List<MediaDTO> getImagesUrlsPageBody() {
    return imagesUrlsPageBody;
  }

  public void setImagesUrlsPageBody(List<MediaDTO> imagesUrlsPageBody) {
    this.imagesUrlsPageBody = imagesUrlsPageBody;
  }

  public PortfolioEntryDTO symbolsDescription(String symbolsDescription) {
    this.symbolsDescription = symbolsDescription;
    return this;
  }

  /**
   * Get symbolsDescription
   * @return symbolsDescription
  */
  
  @Schema(name = "symbolsDescription", required = false)
  public String getSymbolsDescription() {
    return symbolsDescription;
  }

  public void setSymbolsDescription(String symbolsDescription) {
    this.symbolsDescription = symbolsDescription;
  }

  public PortfolioEntryDTO history(String history) {
    this.history = history;
    return this;
  }

  /**
   * Get history
   * @return history
  */
  
  @Schema(name = "history", required = false)
  public String getHistory() {
    return history;
  }

  public void setHistory(String history) {
    this.history = history;
  }

  public PortfolioEntryDTO imagesUrlsPageLeftPane(List<MediaDTO> imagesUrlsPageLeftPane) {
    this.imagesUrlsPageLeftPane = imagesUrlsPageLeftPane;
    return this;
  }

  public PortfolioEntryDTO addImagesUrlsPageLeftPaneItem(MediaDTO imagesUrlsPageLeftPaneItem) {
    if (this.imagesUrlsPageLeftPane == null) {
      this.imagesUrlsPageLeftPane = new ArrayList<>();
    }
    this.imagesUrlsPageLeftPane.add(imagesUrlsPageLeftPaneItem);
    return this;
  }

  /**
   * Get imagesUrlsPageLeftPane
   * @return imagesUrlsPageLeftPane
  */
  @Valid 
  @Schema(name = "imagesUrlsPageLeftPane", required = false)
  public List<MediaDTO> getImagesUrlsPageLeftPane() {
    return imagesUrlsPageLeftPane;
  }

  public void setImagesUrlsPageLeftPane(List<MediaDTO> imagesUrlsPageLeftPane) {
    this.imagesUrlsPageLeftPane = imagesUrlsPageLeftPane;
  }

  public PortfolioEntryDTO documents(List<MediaDTO> documents) {
    this.documents = documents;
    return this;
  }

  public PortfolioEntryDTO addDocumentsItem(MediaDTO documentsItem) {
    if (this.documents == null) {
      this.documents = new ArrayList<>();
    }
    this.documents.add(documentsItem);
    return this;
  }

  /**
   * Get documents
   * @return documents
  */
  @Valid 
  @Schema(name = "documents", required = false)
  public List<MediaDTO> getDocuments() {
    return documents;
  }

  public void setDocuments(List<MediaDTO> documents) {
    this.documents = documents;
  }

  public PortfolioEntryDTO createdAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
  */
  @Pattern(regexp = "/([0-9]{2})-(?:[0-9]{2})-([0-9]{4})/") 
  @Schema(name = "createdAt", required = false)
  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public PortfolioEntryDTO longitude(Double longitude) {
    this.longitude = longitude;
    return this;
  }

  /**
   * Get longitude
   * @return longitude
  */
  
  @Schema(name = "longitude", required = false)
  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public PortfolioEntryDTO latitude(Double latitude) {
    this.latitude = latitude;
    return this;
  }

  /**
   * Get latitude
   * @return latitude
  */
  
  @Schema(name = "latitude", required = false)
  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PortfolioEntryDTO portfolioEntryDTO = (PortfolioEntryDTO) o;
    return Objects.equals(this.id, portfolioEntryDTO.id) &&
        Objects.equals(this.tittle, portfolioEntryDTO.tittle) &&
        Objects.equals(this.modificationDate, portfolioEntryDTO.modificationDate) &&
        Objects.equals(this.creationDate, portfolioEntryDTO.creationDate) &&
        Objects.equals(this.designedElements, portfolioEntryDTO.designedElements) &&
        Objects.equals(this.imageUrl, portfolioEntryDTO.imageUrl) &&
        Objects.equals(this.wojewodztwo, portfolioEntryDTO.wojewodztwo) &&
        Objects.equals(this.powiat, portfolioEntryDTO.powiat) &&
        Objects.equals(this.locationDetails, portfolioEntryDTO.locationDetails) &&
        Objects.equals(this.coatOfArmsDescription, portfolioEntryDTO.coatOfArmsDescription) &&
        Objects.equals(this.imagesUrlsPageBody, portfolioEntryDTO.imagesUrlsPageBody) &&
        Objects.equals(this.symbolsDescription, portfolioEntryDTO.symbolsDescription) &&
        Objects.equals(this.history, portfolioEntryDTO.history) &&
        Objects.equals(this.imagesUrlsPageLeftPane, portfolioEntryDTO.imagesUrlsPageLeftPane) &&
        Objects.equals(this.documents, portfolioEntryDTO.documents) &&
        Objects.equals(this.createdAt, portfolioEntryDTO.createdAt) &&
        Objects.equals(this.longitude, portfolioEntryDTO.longitude) &&
        Objects.equals(this.latitude, portfolioEntryDTO.latitude);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tittle, modificationDate, creationDate, designedElements, imageUrl, wojewodztwo, powiat, locationDetails, coatOfArmsDescription, imagesUrlsPageBody, symbolsDescription, history, imagesUrlsPageLeftPane, documents, createdAt, longitude, latitude);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PortfolioEntryDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    tittle: ").append(toIndentedString(tittle)).append("\n");
    sb.append("    modificationDate: ").append(toIndentedString(modificationDate)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    designedElements: ").append(toIndentedString(designedElements)).append("\n");
    sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
    sb.append("    wojewodztwo: ").append(toIndentedString(wojewodztwo)).append("\n");
    sb.append("    powiat: ").append(toIndentedString(powiat)).append("\n");
    sb.append("    locationDetails: ").append(toIndentedString(locationDetails)).append("\n");
    sb.append("    coatOfArmsDescription: ").append(toIndentedString(coatOfArmsDescription)).append("\n");
    sb.append("    imagesUrlsPageBody: ").append(toIndentedString(imagesUrlsPageBody)).append("\n");
    sb.append("    symbolsDescription: ").append(toIndentedString(symbolsDescription)).append("\n");
    sb.append("    history: ").append(toIndentedString(history)).append("\n");
    sb.append("    imagesUrlsPageLeftPane: ").append(toIndentedString(imagesUrlsPageLeftPane)).append("\n");
    sb.append("    documents: ").append(toIndentedString(documents)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

