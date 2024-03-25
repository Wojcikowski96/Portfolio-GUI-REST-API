package com.example.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
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
 * PageResponseAllOf
 */

@JsonTypeName("PageResponse_allOf")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-25T12:00:34.607742700+01:00[Europe/Warsaw]")
public class PageResponseAllOf {

  @JsonProperty("totalElements")
  private Long totalElements;

  @JsonProperty("totalPages")
  private Integer totalPages;

  @JsonProperty("resultssssssssss")
  @Valid
  private List<Object> resultssssssssss = null;

  public PageResponseAllOf totalElements(Long totalElements) {
    this.totalElements = totalElements;
    return this;
  }

  /**
   * Get totalElements
   * @return totalElements
  */
  
  @Schema(name = "totalElements", example = "1", required = false)
  public Long getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(Long totalElements) {
    this.totalElements = totalElements;
  }

  public PageResponseAllOf totalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  /**
   * Get totalPages
   * @return totalPages
  */
  
  @Schema(name = "totalPages", example = "1", required = false)
  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public PageResponseAllOf resultssssssssss(List<Object> resultssssssssss) {
    this.resultssssssssss = resultssssssssss;
    return this;
  }

  public PageResponseAllOf addResultssssssssssItem(Object resultssssssssssItem) {
    if (this.resultssssssssss == null) {
      this.resultssssssssss = new ArrayList<>();
    }
    this.resultssssssssss.add(resultssssssssssItem);
    return this;
  }

  /**
   * Get resultssssssssss
   * @return resultssssssssss
  */
  
  @Schema(name = "resultssssssssss", required = false)
  public List<Object> getResultssssssssss() {
    return resultssssssssss;
  }

  public void setResultssssssssss(List<Object> resultssssssssss) {
    this.resultssssssssss = resultssssssssss;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageResponseAllOf pageResponseAllOf = (PageResponseAllOf) o;
    return Objects.equals(this.totalElements, pageResponseAllOf.totalElements) &&
        Objects.equals(this.totalPages, pageResponseAllOf.totalPages) &&
        Objects.equals(this.resultssssssssss, pageResponseAllOf.resultssssssssss);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalElements, totalPages, resultssssssssss);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageResponseAllOf {\n");
    sb.append("    totalElements: ").append(toIndentedString(totalElements)).append("\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("    resultssssssssss: ").append(toIndentedString(resultssssssssss)).append("\n");
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

