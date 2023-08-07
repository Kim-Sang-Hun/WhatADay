package com.zerobase.whataday.exception.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
  SCHEDULE_ALREADY_EXISTS(400, "SCHEDULE-ERROR-400", "SCHEDULE ALREADY EXISTS"),
  INTERNAL_SERVER_ERROR(500, "COMMON-ERROR-500", "INTERNAL SERVER ERROR");

  private final int status;
  private final String errorCode;
  private final String message;
}