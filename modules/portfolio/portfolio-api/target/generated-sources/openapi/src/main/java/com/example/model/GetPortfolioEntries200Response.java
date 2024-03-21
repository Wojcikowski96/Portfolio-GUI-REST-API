package com.example.model;

import java.net.URI;
import java.util.Objects;
import com.example.model.PortfolioEntryDTO;
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
 * GetPortfolioEntries200Response
 */

@JsonTypeName("getPortfolioEntries_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-21T11:24:25.303650400+01:00[Europe/Warsaw]")
public class GetPortfolioEntries200Response {

  @JsonProperty("pageNo")
  private Integer pageNo = 1;

  @JsonProperty("pageSize")
  private Integer pageSize = 20;

  @JsonProperty("totalElements")
  private Long totalElements;

  @JsonProperty("totalPages")
  private Integer totalPages;

  @JsonProperty("results")
  @Valid
  private List<PortfolioEntryDTO> results = null;

  public GetPortfolioEntries200Response pageNo(Integer pageNo) {
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

  public GetPortfolioEntries200Response pageSize(Integer pageSize) {
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

  public GetPortfolioEntries200Response totalElements(Long totalElements) {
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

  public GetPortfolioEntries200Response totalPages(Integer totalPages) {
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

  public GetPortfolioEntries200Response results(List<PortfolioEntryDTO> results) {
    this.results = results;
    return this;
  }

  public GetPortfolioEntries200Response addResultsItem(PortfolioEntryDTO resultsItem) {
    if (this.results == null) {
      this.results = new ArrayList<>();
    }
    this.results.add(resultsItem);
    return this;
  }

  /**
   * Get results
   * @return results
  */
  @Valid 
  @Schema(name = "results", required = false)
  public List<PortfolioEntryDTO> getResults() {
    return results;
  }

  public void setResults(List<PortfolioEntryDTO> results) {
    this.results = results;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetPortfolioEntries200Response getPortfolioEntries200Response = (GetPortfolioEntries200Response) o;
    return Objects.equals(this.pageNo, getPortfolioEntries200Response.pageNo) &&
        Objects.equals(this.pageSize, getPortfolioEntries200Response.pageSize) &&
        Objects.equals(this.totalElements, getPortfolioEntries200Response.totalElements) &&
        Objects.equals(this.totalPages, getPortfolioEntries200Response.totalPages) &&
        Objects.equals(this.results, getPortfolioEntries200Response.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageNo, pageSize, totalElements, totalPages, results);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetPortfolioEntries200Response {\n");
    sb.append("    pageNo: ").append(toIndentedString(pageNo)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    totalElements: ").append(toIndentedString(totalElements)).append("\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
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

