package com.zerobase.whataday.controller;

import com.zerobase.whataday.domain.ScheduleForm;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

  @GetMapping("/add")
  public Map<String, String> addSchedule(ScheduleForm schedule){
    Map<String, String> map = new HashMap<>();

    return map;
  }

}