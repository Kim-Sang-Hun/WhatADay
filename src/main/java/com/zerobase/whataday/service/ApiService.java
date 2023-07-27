package com.zerobase.whataday.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ApiService {
  ResponseEntity<String> searchAddress(String address);
}