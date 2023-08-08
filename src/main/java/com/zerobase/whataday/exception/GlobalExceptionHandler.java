package com.zerobase.whataday.exception;

import com.zerobase.whataday.exception.domain.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ScheduleException.class)
  public ResponseEntity<ErrorDTO> handleScheduleException(ScheduleException e) {
    ErrorDTO dto = new ErrorDTO(e.getErrorCode());
    return new ResponseEntity<>(dto, HttpStatus.valueOf(e.getErrorCode().getStatus()));
  }

}