package com.icebear2n2.userservice.domain.repository;

import com.icebear2n2.userservice.domain.entity.UserWish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWishRepository extends JpaRepository<UserWish, Long> {
}
