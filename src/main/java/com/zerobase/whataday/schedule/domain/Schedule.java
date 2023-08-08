package com.zerobase.whataday.schedule.domain;

import com.zerobase.whataday.domain.BaseEntity;
import com.zerobase.whataday.user.domain.User;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
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
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
  @NotBlank(message = "제목은 필수 입력 항목입니다.")
  private String title;
  @NotBlank(message = "내용은 필수 입력 항목입니다.")
  private String description;
  @NotBlank(message = "주소는 필수 입력 항목입니다.")
  private String address;
  @NotBlank(message = "시작 시간은 필수 입력 항목입니다.")
  private LocalDateTime startTime;
  @NotBlank(message = "종료 시간은 필수 입력 항목입니다.")
  private LocalDateTime endTime;

  public static Schedule from(ScheduleRequest scheduleRequest) {
    return Schedule.builder()
        .user(scheduleRequest.getUser())
        .title(scheduleRequest.getTitle())
        .description(scheduleRequest.getDescription())
        .address(scheduleRequest.getAddress())
        .startTime(scheduleRequest.getStartTime())
        .endTime(scheduleRequest.getEndTime())
        .build();
  }

}