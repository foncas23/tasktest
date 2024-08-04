package com.alfonso.tasktest.config.handlerexception;

import com.napptilus.openapi.model.ErrorDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RestApiExceptionHandlerTest {

    private final RestApiExceptionHandler exceptionHandler = new RestApiExceptionHandler();

    @Test
    public void testHandleBadRequestException() {
        IllegalArgumentException exception = new IllegalArgumentException("Invalid argument");

        ResponseEntity<ErrorDTO> response = exceptionHandler.handleBadRequestException(exception);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody()).isNotNull();

        ErrorDTO errorDTO = response.getBody();
        assertThat(errorDTO.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
        assertThat(errorDTO.getTitle()).isEqualTo(HttpStatus.BAD_REQUEST.name());
        assertThat(errorDTO.getDetail()).isEqualTo("Invalid argument");
    }

}