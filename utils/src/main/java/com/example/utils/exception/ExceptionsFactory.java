package com.example.utils.exception;

import org.springframework.http.HttpStatus;

public class ExceptionsFactory {

  public static ApplicationException createConflict(String message, String code, Throwable cause){
    ApplicationException exception = new ApplicationException(message, cause, code);

    exception.setHttpStatus(HttpStatus.CONFLICT);

    exception.setCode(code);

    return exception;
  }

  public static ApplicationException createNotFound(String message, String code, Throwable cause){
    ApplicationException exception = new ApplicationException(message, cause, code);

    exception.setHttpStatus(HttpStatus.NOT_FOUND);

    exception.setCode(code);

    return exception;
  }

  public static ApplicationException createUnauthorized(String message, String code, Throwable cause){
    ApplicationException exception = new ApplicationException(message, cause, code);

    exception.setHttpStatus(HttpStatus.UNAUTHORIZED);

    exception.setCode(code);

    return exception;
  }

  public static ApplicationException createForbidden(String message, String code, Throwable cause){
    ApplicationException exception = new ApplicationException(message, cause, code);

    exception.setHttpStatus(HttpStatus.FORBIDDEN);

    exception.setCode(code);

    return exception;
  }

  public static ApplicationException createInternalServerError(String message, String code, Throwable cause){
    ApplicationException exception = new ApplicationException(message, cause, code);

    exception.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);

    exception.setCode(code);

    return exception;
  }
}
