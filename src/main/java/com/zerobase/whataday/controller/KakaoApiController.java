package com.zerobase.whataday.controller;


import com.zerobase.whataday.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KakaoApiController {
  private final ApiService apiService;

  /**
   * 사용자가 검색한 address 값을 가지고 카카오 location API 사용하여 검색한 주소값, 위도, 경도를 return
   */
  @GetMapping("/search/{address}")
  public ResponseEntity<String> searchAddress(@PathVariable("address") String address) {
      return apiService.searchAddress(address);
  }
}