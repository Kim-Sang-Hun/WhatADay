package com.zerobase.whataday.api.service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {
  @Value("${kakao.api.key}")
  private String key;

  public ResponseEntity<String> searchAddress(String address) {
    if (address.isBlank()) {
      return ResponseEntity.badRequest().build();
    }
    String apiKey = "KakaoAK " + key;
    String url = "https://dapi.kakao.com/v2/local/search/address.json?query=" + address;
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
    headers.setAccept(List.of(MediaType.APPLICATION_JSON));
    headers.set("Authorization", apiKey);

    HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(headers);

    return restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
  }
}