package com.zerobase.whataday.schedule.domain;

import com.zerobase.whataday.user.domain.User;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class ScheduleRequest {
  private User user;
  private String title;
  private String description;
  private String address;
  private LocalDateTime startTime;
  private LocalDateTime endTime;
}