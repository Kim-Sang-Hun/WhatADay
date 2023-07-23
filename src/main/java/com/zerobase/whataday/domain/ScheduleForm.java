package com.zerobase.whataday.domain;

import lombok.Getter;

@Getter
public class ScheduleForm {
  private Long userId;
  private String title;
  private String description;
  private String address;
  private String datetime;
}