package com.example.model;

import java.net.URI;
import java.util.Objects;
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
 * BlogEntryDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-22T16:26:26.867259200+01:00[Europe/Warsaw]")
public class BlogEntryDTO {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("tittle")
  private String tittle;

  @JsonProperty("content")
  private String content;

  @JsonProperty("modificationDate")
  private String modificationDate;

  @JsonProperty("creationDate")
  private String creationDate;

  @JsonProperty("imageUrl")
  private String imageUrl;

  @JsonProperty("newsPortalsUrls")
  @Valid
  private List<String> newsPortalsUrls = null;

  public BlogEntryDTO id(Long id) {
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

  public BlogEntryDTO tittle(String tittle) {
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

  public BlogEntryDTO content(String content) {
    this.content = content;
    return this;
  }

  /**
   * Get content
   * @return content
  */
  
  @Schema(name = "content", required = false)
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public BlogEntryDTO modificationDate(String modificationDate) {
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

  public BlogEntryDTO creationDate(String creationDate) {
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

  public BlogEntryDTO imageUrl(String imageUrl) {
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

  public BlogEntryDTO newsPortalsUrls(List<String> newsPortalsUrls) {
    this.newsPortalsUrls = newsPortalsUrls;
    return this;
  }

  public BlogEntryDTO addNewsPortalsUrlsItem(String newsPortalsUrlsItem) {
    if (this.newsPortalsUrls == null) {
      this.newsPortalsUrls = new ArrayList<>();
    }
    this.newsPortalsUrls.add(newsPortalsUrlsItem);
    return this;
  }

  /**
   * Get newsPortalsUrls
   * @return newsPortalsUrls
  */
  
  @Schema(name = "newsPortalsUrls", required = false)
  public List<String> getNewsPortalsUrls() {
    return newsPortalsUrls;
  }

  public void setNewsPortalsUrls(List<String> newsPortalsUrls) {
    this.newsPortalsUrls = newsPortalsUrls;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BlogEntryDTO blogEntryDTO = (BlogEntryDTO) o;
    return Objects.equals(this.id, blogEntryDTO.id) &&
        Objects.equals(this.tittle, blogEntryDTO.tittle) &&
        Objects.equals(this.content, blogEntryDTO.content) &&
        Objects.equals(this.modificationDate, blogEntryDTO.modificationDate) &&
        Objects.equals(this.creationDate, blogEntryDTO.creationDate) &&
        Objects.equals(this.imageUrl, blogEntryDTO.imageUrl) &&
        Objects.equals(this.newsPortalsUrls, blogEntryDTO.newsPortalsUrls);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tittle, content, modificationDate, creationDate, imageUrl, newsPortalsUrls);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BlogEntryDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    tittle: ").append(toIndentedString(tittle)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    modificationDate: ").append(toIndentedString(modificationDate)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
    sb.append("    newsPortalsUrls: ").append(toIndentedString(newsPortalsUrls)).append("\n");
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

