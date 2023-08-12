package com.zerobase.whataday.user.domain;

import com.zerobase.whataday.domain.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class User extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private String password;
  private String email;
  private boolean isVerifiedByEmail;

  public static User from(UserRequest userRequest) {

    return User.builder().name(userRequest.getName())
        .email(userRequest.getEmail())
        .password(userRequest.getPassword())
        .build();
  }
}