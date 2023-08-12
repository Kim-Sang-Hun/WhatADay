package com.zerobase.whataday.schedule.service;

import com.zerobase.whataday.exception.ScheduleException;
import com.zerobase.whataday.exception.domain.ErrorCode;
import com.zerobase.whataday.schedule.domain.Schedule;
import com.zerobase.whataday.schedule.repository.ScheduleRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

  private final ScheduleRepository scheduleRepository;
  private final JavaMailSender javaMailSender;

  @Value("${mail.myMailAddress}")
  private String myMailAddress;

  @Transactional
  public ResponseEntity<String> addSchedule(Schedule schedule) {

    // 같은 사람이 같은 시간에 스케쥴을 등록하는 것을 막는다.
    if (scheduleRepository.existsByUserIdAndStartTimeBetweenOrEndTimeBetween(schedule.getUser().getId(),
        schedule.getStartTime(), schedule.getEndTime(),
        schedule.getStartTime(), schedule.getEndTime())
    ) {
      throw new ScheduleException("이미 존재하는 스케쥴", ErrorCode.SCHEDULE_ALREADY_EXISTS);
    }
    scheduleRepository.save(schedule);
    return ResponseEntity.ok().build();
  }

  @Transactional
  public ResponseEntity<List<Schedule>> findScheduleNotDone(Long userId) {

    List<Schedule> list = scheduleRepository.findByUserIdAndDoneOrderByStartTime(userId, false);
    if (list.isEmpty()) {
      return ResponseEntity.badRequest().build();
    }

    return ResponseEntity.ok().body(list);
  }

  /**
   *@param localDateTime 을 이용해서 한 시간 뒤에 시작하는 스케쥴을 찾아오고
   *                     그에 대한 알람을 보내준다.
   * 이 때 메일의 내용에는 장소, 스케쥴 제목, 스케쥴 설명이 들어가 있다.
   */
  @Transactional(readOnly = true)
  public void sendEmailOneHourAfter(LocalDateTime localDateTime) {

    List<Schedule> list = scheduleRepository.findByStartTime(localDateTime);

    if (list.isEmpty()) {
      return;
    }

    SimpleMailMessage mail = new SimpleMailMessage();

    try {
      mail.setFrom(myMailAddress);
      mail.setSubject("일정 시작 한 시간 전입니다.");
      String location;
      String title;
      String description;

      for (int i = 0; i < list.size(); i++) {
        location = list.get(i).getAddress();
        title = list.get(i).getTitle();
        description = list.get(i).getDescription();
        mail.setTo(list.get(i).getUser().getEmail());
        mail.setText(location + " 에서 다음 일정이 시작되기까지 한 시간 남았습니다.\n"
            + title + "\n" + description);
        javaMailSender.send(mail);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public ResponseEntity<String> updateScheduleDone(Long scheduleId) {
    Optional<Schedule> schedule = scheduleRepository.findById(scheduleId);
    if (schedule.isEmpty()) {
      return ResponseEntity.badRequest().build();
    }
    Schedule scheduleFound = schedule.get();
    scheduleFound.setDone(true);
    scheduleRepository.save(scheduleFound);
    
    return ResponseEntity.ok().build();
  }
}