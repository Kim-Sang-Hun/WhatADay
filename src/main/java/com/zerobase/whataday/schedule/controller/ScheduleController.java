package com.zerobase.whataday.schedule.controller;

import com.zerobase.whataday.schedule.domain.Schedule;
import com.zerobase.whataday.schedule.domain.ScheduleRequest;
import com.zerobase.whataday.schedule.service.ScheduleService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
@EnableScheduling
public class ScheduleController {

  private final ScheduleService scheduleService;

  @PostMapping("/submit")
  public ResponseEntity<String> addSchedule(@RequestBody ScheduleRequest scheduleRequest) {
    Schedule schedule = Schedule.from(scheduleRequest);

    return scheduleService.addSchedule(schedule);
  }

  /**
   * 스케쥴러를 이용해 15분마다 메일을 보냅니다. 15분마다 메일을 보내는 이유는 사용자가 많아질 경우 그 때마다 DB에 접속하는 특성상 성능에 문제가 생길 수 있기
   * 때문입니다. (스케쥴에 입력받는 시간도 15분 단위로 받는 것으로 합니다)
   */
  @Scheduled(cron = "* 0/15 * * * *")
  public void sendEmail() {
    scheduleService.sendEmailOneHourAfter(LocalDateTime.now().plusHours(1));
  }

}