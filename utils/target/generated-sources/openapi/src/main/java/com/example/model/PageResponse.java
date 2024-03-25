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
 * PageResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-25T12:00:34.607742700+01:00[Europe/Warsaw]")
public class PageResponse {

  @JsonProperty("pageNo")
  private Integer pageNo = 1;

  @JsonProperty("pageSize")
  private Integer pageSize = 20;

  @JsonProperty("totalElements")
  private Long totalElements;

  @JsonProperty("totalPages")
  private Integer totalPages;

  @JsonProperty("resultssssssssss")
  @Valid
  private List<Object> resultssssssssss = null;

  public PageResponse pageNo(Integer pageNo) {
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

  public PageResponse pageSize(Integer pageSize) {
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

  public PageResponse totalElements(Long totalElements) {
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

  public PageResponse totalPages(Integer totalPages) {
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

  public PageResponse resultssssssssss(List<Object> resultssssssssss) {
    this.resultssssssssss = resultssssssssss;
    return this;
  }

  public PageResponse addResultssssssssssItem(Object resultssssssssssItem) {
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
    PageResponse pageResponse = (PageResponse) o;
    return Objects.equals(this.pageNo, pageResponse.pageNo) &&
        Objects.equals(this.pageSize, pageResponse.pageSize) &&
        Objects.equals(this.totalElements, pageResponse.totalElements) &&
        Objects.equals(this.totalPages, pageResponse.totalPages) &&
        Objects.equals(this.resultssssssssss, pageResponse.resultssssssssss);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageNo, pageSize, totalElements, totalPages, resultssssssssss);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageResponse {\n");
    sb.append("    pageNo: ").append(toIndentedString(pageNo)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
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

