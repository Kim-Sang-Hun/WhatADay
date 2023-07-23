package com.zerobase.whataday.domain;

import lombok.Data;

@Data
public class SignUpForm {
  private Long Id;
  private String name;
  private String password;
  private String email;
}