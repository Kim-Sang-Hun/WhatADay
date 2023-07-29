package com.zerobase.whataday.schedule.controller;

import com.zerobase.whataday.schedule.domain.Schedule;
import com.zerobase.whataday.schedule.domain.ScheduleInput;
import com.zerobase.whataday.schedule.service.ScheduleService;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

  private final ScheduleService scheduleService;
  @PostMapping("/submit")
  public ResponseEntity<?> addSchedule(ScheduleInput scheduleInput){
    Schedule schedule = Schedule.builder()
        .userId(scheduleInput.getUserId())
        .title(scheduleInput.getTitle())
        .description(scheduleInput.getDescription())
        .address(scheduleInput.getAddress())
        .datetime(scheduleInput.getDatetime())
        .build();

    if (!scheduleService.addSchedule(schedule)) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok().build();
  }

}