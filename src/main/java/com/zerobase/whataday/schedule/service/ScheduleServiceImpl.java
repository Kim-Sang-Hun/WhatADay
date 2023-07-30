package com.zerobase.whataday.schedule.service;

import com.zerobase.whataday.schedule.domain.Schedule;
import com.zerobase.whataday.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

  private final ScheduleRepository scheduleRepository;
  @Override
  public boolean addSchedule(Schedule schedule) {

    // 같은 사람이 같은 시간에 스케쥴을 등록하는 것을 막는다.
    if (scheduleRepository.existsByUserIdAndDatetime(schedule.getUserId(),
        schedule.getDatetime())) {
      return false;
    }

    scheduleRepository.save(schedule);
    return true;
  }
}