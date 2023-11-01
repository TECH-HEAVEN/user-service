package com.icebear2n2.userservice.domain.repository.cart;

import com.icebear2n2.userservice.domain.entity.cart.Cart;
import com.icebear2n2.userservice.domain.entity.cart.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {


}
