package com.alfonso.tasktest.config.handlerexception;

import com.napptilus.openapi.model.ErrorDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ApiErrorResponseBuilderTest {

    @Test
    public void testBuildResponse() {
        // Given
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String message = "Invalid request";

        // When
        ResponseEntity<ErrorDTO> response = ApiErrorResponseBuilder.buildResponse(status, message);

        // Then
        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(status);
        assertThat(response.getBody()).isNotNull();

        ErrorDTO errorDTO = response.getBody();
        assertThat(errorDTO.getStatus()).isEqualTo(status.value());
        assertThat(errorDTO.getTitle()).isEqualTo(status.name());
        assertThat(errorDTO.getDetail()).isEqualTo(message);
    }

}