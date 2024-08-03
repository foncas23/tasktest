package com.alfonso.tasktest.config.handlerexception;

import com.napptilus.openapi.model.ErrorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiErrorResponseBuilder {

  private static final Logger LOGGER = LoggerFactory.getLogger(ApiErrorResponseBuilder.class);

  private ApiErrorResponseBuilder() {}

  public static ResponseEntity<ErrorDTO> buildResponse(
      final HttpStatus status, final String message) {
    final ErrorDTO ErrorDTO = new ErrorDTO();
    ErrorDTO.setStatus(status.value());
    ErrorDTO.setTitle(status.name());
    ErrorDTO.setDetail(message);
    LOGGER.error("[Error] {} message: {}", status, message);
    return ResponseEntity.status(status).body(ErrorDTO);
  }
}
