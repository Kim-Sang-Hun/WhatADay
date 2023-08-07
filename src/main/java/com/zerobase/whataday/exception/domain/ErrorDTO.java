package com.zerobase.whataday.exception.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDTO {
  private int status;
  private String errorCode;
  private String message;

  public ErrorDTO(ErrorCode errorCode) {
    this.status = errorCode.getStatus();
    this.errorCode = errorCode.getErrorCode();
    this.message = errorCode.getMessage();
  }
}