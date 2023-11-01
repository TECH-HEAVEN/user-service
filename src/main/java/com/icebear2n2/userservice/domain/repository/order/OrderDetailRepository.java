package com.icebear2n2.userservice.domain.repository.order;

import com.icebear2n2.userservice.domain.entity.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
