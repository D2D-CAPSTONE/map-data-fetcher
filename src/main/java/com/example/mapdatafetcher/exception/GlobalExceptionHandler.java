package com.example.mapdatafetcher.exception;

import com.example.mapdatafetcher.dto.ErrorResponse;
import com.example.mapdatafetcher.dto.ValidationErrorResponse;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(BindException.class)
  public ResponseEntity<ValidationErrorResponse> handleValidation(BindException exception) {
    Map<String, String> errors = new LinkedHashMap<>();
    for (FieldError fieldError : exception.getFieldErrors()) {
      errors.put(fieldError.getField(), fieldError.getDefaultMessage());
    }

    return ResponseEntity.badRequest().body(new ValidationErrorResponse("Invalid request", errors));
  }

  @ExceptionHandler(RestClientException.class)
  public ResponseEntity<ErrorResponse> handleRestClient(RestClientException exception) {
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
        .body(new ErrorResponse("Failed to call Kakao map search", exception.getMessage()));
  }

  @ExceptionHandler(AppConfigurationException.class)
  public ResponseEntity<ErrorResponse> handleAppConfiguration(AppConfigurationException exception) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new ErrorResponse("Application configuration error", exception.getMessage()));
  }

  @ExceptionHandler(IllegalStateException.class)
  public ResponseEntity<ErrorResponse> handleIllegalState(IllegalStateException exception) {
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
        .body(
            new ErrorResponse(
                "Failed to capture browser network response", exception.getMessage()));
  }
}
