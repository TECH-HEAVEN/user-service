package com.icebear2n2.userservice.domain.repository;

import com.icebear2n2.userservice.domain.entity.cart.CartItem;
import com.icebear2n2.userservice.domain.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
