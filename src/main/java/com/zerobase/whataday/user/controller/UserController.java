package com.zerobase.whataday.user.controller;

import com.zerobase.whataday.domain.User;
import com.zerobase.whataday.domain.UserInput;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @PostMapping("/user/submit")
  public ResponseEntity<?> addUser(@RequestBody @Valid UserInput userInput) {




    User user = User.builder()
        .name(userInput.getName())
        .password(userInput.getPassword())
        .email(userInput.getEmail())
        .build();

    return ResponseEntity.ok().build();
  }
}