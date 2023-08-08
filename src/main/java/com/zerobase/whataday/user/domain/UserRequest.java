package com.zerobase.whataday.user.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class UserRequest {

  private Long Id;
  @NotBlank(message = "이름은 필수 항목입니다.")
  private String name;
  @Size(min = 4, message = "비밀번호는 4자 이상 입력해야 합니다.")
  @NotBlank(message = "비밀번호는 필수 항목입니다.")
  private String password;
  @Email(message = "이메일 형식에 맞게 입력해주십시오.")
  @NotBlank(message = "이메일은 필수 항목입니다.")
  private String email;
}