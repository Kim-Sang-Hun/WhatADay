package com.zerobase.whataday.schedule.repository;

import com.zerobase.whataday.schedule.domain.Schedule;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
  boolean existsByUserIdAndStartTimeBetweenOrEndTimeBetween(Long userId,
      LocalDateTime startTime1, LocalDateTime endTime1,
      LocalDateTime startTime2, LocalDateTime endTime2);
  List<Schedule> findByStartTime(LocalDateTime localDateTime);
  List<Schedule> findByEndTime(LocalDateTime localDateTime);

  List<Schedule> findByUserIdAndDoneOrderByStartTime(Long userId, boolean Done);
}