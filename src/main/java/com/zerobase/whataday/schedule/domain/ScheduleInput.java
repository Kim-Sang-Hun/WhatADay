package com.zerobase.whataday.schedule.domain;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class ScheduleInput {
  private Long userId;
  private String title;
  private String description;
  private String address;
  private LocalDateTime datetime;
}