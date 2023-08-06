package com.zerobase.whataday.schedule.repository;

import com.zerobase.whataday.schedule.domain.Schedule;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
  boolean existsByUserIdAndDatetime(Long userId, LocalDateTime dateTime);
  List<Schedule> findSchedulesByDatetime(LocalDateTime localDateTime);
}