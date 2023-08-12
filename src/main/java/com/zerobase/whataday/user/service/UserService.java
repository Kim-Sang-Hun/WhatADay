package com.zerobase.whataday.user.service;

import com.zerobase.whataday.user.domain.User;
import com.zerobase.whataday.user.domain.UserRequest;
import com.zerobase.whataday.user.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public ResponseEntity<String> addUser(UserRequest userRequest) {
    Optional<User> user = userRepository.findByEmailOrName(userRequest.getEmail(), userRequest.getName());

    if (user.isPresent()) {
      return ResponseEntity.badRequest().build();
    }

    String newPassword = passwordEncoder.encode(userRequest.getPassword());
    userRequest.setPassword(newPassword);

    userRepository.save(User.from(userRequest));
    return ResponseEntity.ok().build();
  }

}