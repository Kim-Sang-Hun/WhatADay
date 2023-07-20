package com.zerobase.whataday.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SignUpForm {
  private Long Id;
  private String name;
  private String password;
  private String email;
}