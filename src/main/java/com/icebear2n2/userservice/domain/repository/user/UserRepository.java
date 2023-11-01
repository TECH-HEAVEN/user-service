package com.icebear2n2.userservice.domain.repository.user;

import com.icebear2n2.userservice.domain.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUserId(Long userId);
}