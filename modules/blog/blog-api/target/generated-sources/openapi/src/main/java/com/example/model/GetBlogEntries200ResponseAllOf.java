package com.example.model;

import java.net.URI;
import java.util.Objects;
import com.example.model.BlogEntryDTO;
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
 * GetBlogEntries200ResponseAllOf
 */

@JsonTypeName("getBlogEntries_200_response_allOf")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-22T16:26:26.867259200+01:00[Europe/Warsaw]")
public class GetBlogEntries200ResponseAllOf {

  @JsonProperty("results")
  @Valid
  private List<BlogEntryDTO> results = null;

  public GetBlogEntries200ResponseAllOf results(List<BlogEntryDTO> results) {
    this.results = results;
    return this;
  }

  public GetBlogEntries200ResponseAllOf addResultsItem(BlogEntryDTO resultsItem) {
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
  public List<BlogEntryDTO> getResults() {
    return results;
  }

  public void setResults(List<BlogEntryDTO> results) {
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
    GetBlogEntries200ResponseAllOf getBlogEntries200ResponseAllOf = (GetBlogEntries200ResponseAllOf) o;
    return Objects.equals(this.results, getBlogEntries200ResponseAllOf.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(results);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetBlogEntries200ResponseAllOf {\n");
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

