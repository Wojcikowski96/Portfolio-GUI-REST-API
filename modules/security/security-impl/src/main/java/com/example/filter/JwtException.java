package com.example.filter;

import com.example.model.Error;
import com.example.utils.exception.ApplicationException;
import com.example.utils.exception.ExceptionsFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JwtException implements AuthenticationEntryPoint, Serializable {


  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response,
                       AuthenticationException authException) throws IOException {

    ApplicationException appException;
    if (authException instanceof BadCredentialsException) {
      appException = ExceptionsFactory.createUnauthorized("Niepoprawne dane uwierzytelniające", "NDU", authException);
    } else if (authException instanceof InsufficientAuthenticationException) {
      appException = ExceptionsFactory.createUnauthorized("Brak autoryzacji do wykonania requestu", "BADWR", authException);
    } else {
      appException = ExceptionsFactory.createInternalServerError("Runtime exception", "RE", authException);
    }

    Error errorDto = new Error();

    errorDto.setMessage(appException.getMessage());

    errorDto.setCode(appException.getCode());

    response.setStatus(appException.getHttpStatus().value());

    OutputStream out = response.getOutputStream();
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(out, errorDto);
    out.flush();

  }
}
