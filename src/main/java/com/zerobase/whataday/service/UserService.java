package com.zerobase.whataday.service;

import com.zerobase.whataday.domain.UserInput;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
  String signUp(UserInput form);

}