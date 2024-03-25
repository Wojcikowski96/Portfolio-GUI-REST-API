package com.example.model;

import java.net.URI;
import java.util.Objects;
import com.example.model.BlogEntryDTO;
import com.example.model.CommentDTO;
import com.example.model.Pagination;
import com.example.model.Sort;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
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
 * Obiekt do filtrowania i paginacji, filtrowanie i paginacja w zależności od potrzeby na dany request.
 */

@Schema(name = "BlogRequestData", description = "Obiekt do filtrowania i paginacji, filtrowanie i paginacja w zależności od potrzeby na dany request.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-22T16:26:26.867259200+01:00[Europe/Warsaw]")
public class BlogRequestData {

  @JsonProperty("pageNo")
  private Integer pageNo = 1;

  @JsonProperty("pageSize")
  private Integer pageSize = 20;

  /**
   * Gets or Sets sortDir
   */
  public enum SortDirEnum {
    ASC("ASC"),
    
    DESC("DESC");

    private String value;

    SortDirEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SortDirEnum fromValue(String value) {
      for (SortDirEnum b : SortDirEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("sortDir")
  private SortDirEnum sortDir = SortDirEnum.ASC;

  @JsonProperty("sortBy")
  private String sortBy;

  @JsonProperty("id")
  private String id;

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

  @JsonProperty("description")
  private String description;

  public BlogRequestData pageNo(Integer pageNo) {
    this.pageNo = pageNo;
    return this;
  }

  /**
   * Get pageNo
   * @return pageNo
  */
  
  @Schema(name = "pageNo", example = "1", required = false)
  public Integer getPageNo() {
    return pageNo;
  }

  public void setPageNo(Integer pageNo) {
    this.pageNo = pageNo;
  }

  public BlogRequestData pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  /**
   * Get pageSize
   * @return pageSize
  */
  
  @Schema(name = "pageSize", example = "10", required = false)
  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public BlogRequestData sortDir(SortDirEnum sortDir) {
    this.sortDir = sortDir;
    return this;
  }

  /**
   * Get sortDir
   * @return sortDir
  */
  
  @Schema(name = "sortDir", required = false)
  public SortDirEnum getSortDir() {
    return sortDir;
  }

  public void setSortDir(SortDirEnum sortDir) {
    this.sortDir = sortDir;
  }

  public BlogRequestData sortBy(String sortBy) {
    this.sortBy = sortBy;
    return this;
  }

  /**
   * Get sortBy
   * @return sortBy
  */
  
  @Schema(name = "sortBy", example = "name", required = false)
  public String getSortBy() {
    return sortBy;
  }

  public void setSortBy(String sortBy) {
    this.sortBy = sortBy;
  }

  public BlogRequestData id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", required = false)
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BlogRequestData tittle(String tittle) {
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

  public BlogRequestData content(String content) {
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

  public BlogRequestData modificationDate(String modificationDate) {
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

  public BlogRequestData creationDate(String creationDate) {
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

  public BlogRequestData imageUrl(String imageUrl) {
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

  public BlogRequestData newsPortalsUrls(List<String> newsPortalsUrls) {
    this.newsPortalsUrls = newsPortalsUrls;
    return this;
  }

  public BlogRequestData addNewsPortalsUrlsItem(String newsPortalsUrlsItem) {
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

  public BlogRequestData description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  
  @Schema(name = "description", required = false)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BlogRequestData blogRequestData = (BlogRequestData) o;
    return Objects.equals(this.pageNo, blogRequestData.pageNo) &&
        Objects.equals(this.pageSize, blogRequestData.pageSize) &&
        Objects.equals(this.sortDir, blogRequestData.sortDir) &&
        Objects.equals(this.sortBy, blogRequestData.sortBy) &&
        Objects.equals(this.id, blogRequestData.id) &&
        Objects.equals(this.tittle, blogRequestData.tittle) &&
        Objects.equals(this.content, blogRequestData.content) &&
        Objects.equals(this.modificationDate, blogRequestData.modificationDate) &&
        Objects.equals(this.creationDate, blogRequestData.creationDate) &&
        Objects.equals(this.imageUrl, blogRequestData.imageUrl) &&
        Objects.equals(this.newsPortalsUrls, blogRequestData.newsPortalsUrls) &&
        Objects.equals(this.description, blogRequestData.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageNo, pageSize, sortDir, sortBy, id, tittle, content, modificationDate, creationDate, imageUrl, newsPortalsUrls, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BlogRequestData {\n");
    sb.append("    pageNo: ").append(toIndentedString(pageNo)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    sortDir: ").append(toIndentedString(sortDir)).append("\n");
    sb.append("    sortBy: ").append(toIndentedString(sortBy)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    tittle: ").append(toIndentedString(tittle)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    modificationDate: ").append(toIndentedString(modificationDate)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
    sb.append("    newsPortalsUrls: ").append(toIndentedString(newsPortalsUrls)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

