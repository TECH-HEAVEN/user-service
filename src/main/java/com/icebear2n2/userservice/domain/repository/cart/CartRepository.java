package com.icebear2n2.userservice.domain.repository;

import com.icebear2n2.userservice.domain.entity.cart.Cart;
import com.icebear2n2.userservice.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
