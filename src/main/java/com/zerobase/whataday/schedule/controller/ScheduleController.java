package com.zerobase.whataday.schedule.controller;

import com.zerobase.whataday.schedule.domain.Schedule;
import com.zerobase.whataday.schedule.domain.ScheduleRequest;
import com.zerobase.whataday.schedule.service.ScheduleService;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;
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
  public ResponseEntity<String> addSchedule(@RequestBody @Valid ScheduleRequest scheduleRequest) {
    Schedule schedule = Schedule.from(scheduleRequest);

    return scheduleService.addSchedule(schedule);
  }

  @PostMapping("/find")
  public ResponseEntity<List<Schedule>> findSchedule(@RequestBody Long userId) {
    return scheduleService.findScheduleNotDone(userId);
  }

  @Scheduled(cron = "0 * * * * *")
  public void doSchedule() {
    scheduleService.updateScheduleDone(LocalDateTime.now());
  }

  /**
   * 스케쥴러를 이용해 1분마다 한 시간 뒤에 시작하는 일정에 대해 메일을 보냅니다.
   */
  @Scheduled(cron = "0 * * * * *")
  public void sendEmail() {
    scheduleService.sendEmailOneHourAfter(LocalDateTime.now().plusHours(1));
  }

}