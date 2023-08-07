package com.zerobase.whataday.schedule;

import com.zerobase.whataday.domain.User;
import com.zerobase.whataday.exception.ScheduleException;
import com.zerobase.whataday.schedule.domain.Schedule;
import com.zerobase.whataday.schedule.repository.ScheduleRepository;
import com.zerobase.whataday.schedule.service.ScheduleService;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
public class ScheduleServiceTest {

  ScheduleService scheduleService;

  @MockBean
  ScheduleRepository scheduleRepository;
  @MockBean
  JavaMailSender javaMailSender;

  @BeforeEach
  void setUp() {
    scheduleService = new ScheduleService(scheduleRepository, javaMailSender);
  }

  @Test
  @DisplayName("스케쥴 저장")
  void addSchedule() {
    //given
    Schedule schedule1 = Schedule.builder()
        .user(User.builder().id(1L).build())
        .datetime(LocalDateTime.of(2023, 3, 3, 13, 0))
        .build();

    Mockito.when(scheduleRepository.existsByUserIdAndDatetime(schedule1.getUser().getId(), schedule1.getDatetime())).thenReturn(true);

    //when
    //then
    Assertions.assertThrows(ScheduleException.class, () -> {
      scheduleService.addSchedule(schedule1);
    });
  }
}