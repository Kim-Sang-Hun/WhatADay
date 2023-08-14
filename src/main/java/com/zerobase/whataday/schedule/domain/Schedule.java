package com.zerobase.whataday.schedule.domain;

import com.zerobase.whataday.domain.BaseEntity;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class Schedule extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long userId;
  private String title;
  private String description;
  private String address;
  private LocalDateTime startTime;
  private LocalDateTime endTime;
  private boolean done;

  public static Schedule from(ScheduleRequest scheduleRequest) {
    return Schedule.builder()
        .userId(scheduleRequest.getUserId())
        .title(scheduleRequest.getTitle())
        .description(scheduleRequest.getDescription())
        .address(scheduleRequest.getAddress())
        .startTime(scheduleRequest.getStartTime())
        .endTime(scheduleRequest.getEndTime())
        .done(false)
        .build();
  }

}