package com.zerobase.whataday.exception;

import com.zerobase.whataday.exception.domain.ErrorCode;
import lombok.Getter;

@Getter
public class ScheduleException extends RuntimeException {
  private final ErrorCode errorCode;
  public ScheduleException(String message, ErrorCode errorCode) {
    super(message);
    this.errorCode = errorCode;
  }
}