package com.example.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * EmailDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-21T11:24:43.666918900+01:00[Europe/Warsaw]")
public class EmailDTO {

  @JsonProperty("nick")
  private String nick;

  @JsonProperty("email")
  private String email;

  @JsonProperty("tittle")
  private String tittle;

  @JsonProperty("content")
  private String content;

  public EmailDTO nick(String nick) {
    this.nick = nick;
    return this;
  }

  /**
   * Get nick
   * @return nick
  */
  
  @Schema(name = "nick", required = false)
  public String getNick() {
    return nick;
  }

  public void setNick(String nick) {
    this.nick = nick;
  }

  public EmailDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  
  @Schema(name = "email", required = false)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public EmailDTO tittle(String tittle) {
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

  public EmailDTO content(String content) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmailDTO emailDTO = (EmailDTO) o;
    return Objects.equals(this.nick, emailDTO.nick) &&
        Objects.equals(this.email, emailDTO.email) &&
        Objects.equals(this.tittle, emailDTO.tittle) &&
        Objects.equals(this.content, emailDTO.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nick, email, tittle, content);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmailDTO {\n");
    sb.append("    nick: ").append(toIndentedString(nick)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    tittle: ").append(toIndentedString(tittle)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
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

