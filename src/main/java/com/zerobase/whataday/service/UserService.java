package com.zerobase.whataday.service;

import com.zerobase.whataday.domain.SignUpForm;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
  String signUp(SignUpForm form);

}