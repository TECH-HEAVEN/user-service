package com.icebear2n2.userservice.domain.repository.delivery;

import com.icebear2n2.userservice.domain.entity.delivery.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    boolean existsByDeliveryId(Long deliveryId);
}
