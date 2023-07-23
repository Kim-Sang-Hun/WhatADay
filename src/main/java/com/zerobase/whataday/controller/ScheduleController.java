package com.zerobase.whataday.controller;

import com.zerobase.whataday.domain.ScheduleForm;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

  @GetMapping("/add")
  public Map<String, String> addSchedule(ScheduleForm schedule){
    Map<String, String> map = new HashMap<>();

    return map;
  }

  /**
   * 사용자가 검색한 address 값을 가지고
   * 카카오 location API 사용하여
   * 검색한 주소값, 위도, 경도를 return
   */
  @GetMapping("/search/address")
  public String searchAddress() throws URISyntaxException {
    String apiKey = "";
    String address = "서울시청";
    String url = "https://dapi.kakao.com/v2/local/search/address.JSON?query=" + address;
    String apiResult = "";

    try {
      URI uri = new URI(String.format(url, apiKey));
      RestTemplate restTemplate = new RestTemplate();
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

      apiResult = restTemplate.getForObject(uri, String.class);


    } catch (Exception e) {
      e.printStackTrace();
    }

    return apiResult;
  }


}