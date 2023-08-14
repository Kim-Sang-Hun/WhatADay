package com.zerobase.whataday.schedule.domain;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class ScheduleRequest {
  private Long userId;
  private String title;
  private String description;
  private String address;
  private LocalDateTime startTime;
  private LocalDateTime endTime;
}