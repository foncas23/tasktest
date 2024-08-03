package com.alfonso.tasktest.config.handlerexception;

import com.napptilus.openapi.model.ErrorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestApiExceptionHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(RestApiExceptionHandler.class);

  private static final String MESSAGE = "Error: ";

  @ExceptionHandler({IllegalArgumentException.class})
  public ResponseEntity<ErrorDTO> handleBadRequestException(final Exception exception) {
    LOGGER.error(MESSAGE, exception);
    return ApiErrorResponseBuilder.buildResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
  }
}
