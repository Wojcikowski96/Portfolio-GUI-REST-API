package com.example.utils.exception;

import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Data
@ToString(callSuper = true)
public class ApplicationException extends RuntimeException{

  private HttpStatus httpStatus;

  private String code;

  protected ApplicationException(String message, Throwable cause, String code) {
    super(message, cause);
  }


}
