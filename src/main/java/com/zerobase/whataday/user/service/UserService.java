package com.zerobase.whataday.user.service;

import com.zerobase.whataday.user.domain.UserRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
  String signUp(UserRequest form);

}