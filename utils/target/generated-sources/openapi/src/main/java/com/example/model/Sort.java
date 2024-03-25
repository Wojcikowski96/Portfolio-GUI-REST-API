package com.example.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Sort
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-25T13:06:48.951468800+01:00[Europe/Warsaw]")
public class Sort {

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

  public Sort sortDir(SortDirEnum sortDir) {
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

  public Sort sortBy(String sortBy) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sort sort = (Sort) o;
    return Objects.equals(this.sortDir, sort.sortDir) &&
        Objects.equals(this.sortBy, sort.sortBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sortDir, sortBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sort {\n");
    sb.append("    sortDir: ").append(toIndentedString(sortDir)).append("\n");
    sb.append("    sortBy: ").append(toIndentedString(sortBy)).append("\n");
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

