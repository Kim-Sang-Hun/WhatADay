package com.zerobase.whataday.schedule;

import com.zerobase.whataday.schedule.domain.Schedule;
import com.zerobase.whataday.schedule.repository.ScheduleRepository;
import com.zerobase.whataday.schedule.service.ScheduleService;
import com.zerobase.whataday.schedule.service.ScheduleServiceImpl;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
public class ScheduleServiceTest {

  ScheduleService scheduleService;

  @MockBean
  ScheduleRepository scheduleRepository;

  @BeforeEach
  void setUp() {
    scheduleService = new ScheduleServiceImpl(scheduleRepository);
  }

  @Test
  @DisplayName("스케쥴 저장")
  void addSchedule() {
    //given
    Schedule schedule1 = Schedule.builder()
        .userId(1L)
        .datetime(LocalDateTime.of(2023, 3, 3, 13, 0))
        .build();

    Mockito.when(scheduleRepository.existsByUserIdAndDatetime(schedule1.getUserId(), schedule1.getDatetime())).thenReturn(true);

    //when
    boolean result1 = scheduleService.addSchedule(schedule1);
    //then
    Assertions.assertFalse(result1);
  }
}