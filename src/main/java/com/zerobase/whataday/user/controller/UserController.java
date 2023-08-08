package com.zerobase.whataday.user.controller;

import com.zerobase.whataday.user.domain.User;
import com.zerobase.whataday.user.domain.UserRequest;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @PostMapping("/user/submit")
  public ResponseEntity<?> addUser(@RequestBody @Valid UserRequest userRequest) {




    User user = User.builder()
        .name(userRequest.getName())
        .password(userRequest.getPassword())
        .email(userRequest.getEmail())
        .build();

    return ResponseEntity.ok().build();
  }
}