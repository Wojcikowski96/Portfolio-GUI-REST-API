package com.example.utils.exception;

import java.nio.file.AccessDeniedException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import com.example.model.Error;

@ControllerAdvice
public class RestExceptionHandler{


  @ExceptionHandler({AccessDeniedException.class})
  @Order(1)
  public ResponseEntity<Object> handleAccessDeniedException(Exception ex, WebRequest request) {
    return new ResponseEntity<Object>(
        "Access denied message here", new HttpHeaders(), HttpStatus.FORBIDDEN);
  }

  @ExceptionHandler({ApplicationException.class})
  @Order(2)
  public ResponseEntity<Error> handleApplicationException(Exception ex, WebRequest request) {
    ApplicationException appException = (ApplicationException) ex;

    Error errorDto = new Error();

    errorDto.setCode(appException.getCode());

    errorDto.setMessage(appException.getMessage());

    return new ResponseEntity<Error>(
        errorDto, appException.getHttpStatus());
  }

  @ExceptionHandler({RuntimeException.class})
  @Order(3)
  public ResponseEntity<Error> handleRuntimeException(Exception ex) {
    ApplicationException appException =
        ExceptionsFactory.createInternalServerError("Runtime exception", "RE", ex);

    Error errorDto = new Error();

    errorDto.setCode(appException.getCode());

    errorDto.setMessage(appException.getMessage());

    return new ResponseEntity<Error>(
        errorDto, appException.getHttpStatus());
  }
}

