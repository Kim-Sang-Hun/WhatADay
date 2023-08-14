package com.zerobase.whataday.user.controller;

import com.zerobase.whataday.user.domain.UserRequest;
import com.zerobase.whataday.user.service.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/user/submit")
  public ResponseEntity<?> addUser(@RequestBody @Valid UserRequest userRequest) {

    return userService.addUser(userRequest);
  }
}