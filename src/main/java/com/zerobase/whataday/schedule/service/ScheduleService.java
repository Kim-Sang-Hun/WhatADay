package com.zerobase.whataday.schedule.service;

import com.zerobase.whataday.schedule.domain.Schedule;
import org.springframework.stereotype.Service;

@Service
public interface ScheduleService {
  boolean addSchedule(Schedule schedule);
}