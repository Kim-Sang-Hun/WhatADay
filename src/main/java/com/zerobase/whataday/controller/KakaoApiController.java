package com.zerobase.whataday.controller;

import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class KakaoApiController {

  /**
   * 사용자가 검색한 address 값을 가지고 카카오 location API 사용하여 검색한 주소값, 위도, 경도를 return
   */
  @GetMapping("/search/{address}")
  public ResponseEntity<?> searchAddress(@PathVariable("address") String address) throws Exception {
    String apiKey = "KakaoAK " + "dcaa9a59bbcfc8f49ef3f4fc53648c4e";
    String url = "https://dapi.kakao.com/v2/local/search/address.json?query=" + address;
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
    headers.setAccept(List.of(MediaType.APPLICATION_JSON));
    headers.set("Authorization", apiKey);

    HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(headers);
    ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
        String.class);

    return responseEntity;
  }
}