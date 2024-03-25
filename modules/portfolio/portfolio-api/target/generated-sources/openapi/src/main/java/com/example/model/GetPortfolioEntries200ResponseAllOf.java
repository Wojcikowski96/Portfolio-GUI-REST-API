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
 * GetPortfolioEntries200ResponseAllOf
 */

@JsonTypeName("getPortfolioEntries_200_response_allOf")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-25T13:23:39.080943500+01:00[Europe/Warsaw]")
public class GetPortfolioEntries200ResponseAllOf {

  @JsonProperty("results")
  @Valid
  private List<PortfolioEntryDTO> results = null;

  public GetPortfolioEntries200ResponseAllOf results(List<PortfolioEntryDTO> results) {
    this.results = results;
    return this;
  }

  public GetPortfolioEntries200ResponseAllOf addResultsItem(PortfolioEntryDTO resultsItem) {
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
    GetPortfolioEntries200ResponseAllOf getPortfolioEntries200ResponseAllOf = (GetPortfolioEntries200ResponseAllOf) o;
    return Objects.equals(this.results, getPortfolioEntries200ResponseAllOf.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(results);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetPortfolioEntries200ResponseAllOf {\n");
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

