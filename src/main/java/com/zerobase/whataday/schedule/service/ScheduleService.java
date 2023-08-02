package com.zerobase.whataday.schedule.service;

import com.zerobase.whataday.schedule.domain.Schedule;
import com.zerobase.whataday.schedule.repository.ScheduleRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

  private final ScheduleRepository scheduleRepository;

  public boolean addSchedule(Schedule schedule) {

    // 같은 사람이 같은 시간에 스케쥴을 등록하는 것을 막는다.
    if (scheduleRepository.existsByUserIdAndDatetime(schedule.getUser().getId(),
        schedule.getDatetime())) {
      return false;
    }

    scheduleRepository.save(schedule);
    return true;
  }

  public void sendEmailOneHourAfter(LocalDateTime localDateTime) {

    List<Schedule> list = scheduleRepository.findSchedulesByDatetime(localDateTime);
    if (list == null) {
      return;
    }

    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

    try {
      String[] receiveList = new String[list.size()];
      for (int i = 0; i < receiveList.length; i++) {
        receiveList[i] = list.get(i).getUser().getEmail();
      }

      simpleMailMessage.setTo(receiveList);
      simpleMailMessage.setSubject("일정 한시간 전입니다.");
      simpleMailMessage.setText("일정 한시간 전입니다. 늦지 않게 도착해주세요!");

      JavaMailSender sender = new JavaMailSenderImpl();
      sender.send(simpleMailMessage);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}