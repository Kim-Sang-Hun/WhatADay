package com.zerobase.whataday.schedule.domain;

import com.zerobase.whataday.domain.User;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class ScheduleInput {
  private User user;
  private String title;
  private String description;
  private String address;
  private LocalDateTime datetime;
}