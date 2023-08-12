package com.zerobase.whataday.user.repository;

import com.zerobase.whataday.user.domain.User;
import com.zerobase.whataday.user.domain.UserRequest;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmailOrName(String email, String name);
}