package com.icebear2n2.userservice.domain.entity.delivery;

import com.icebear2n2.userservice.domain.entity.order.Order;
import com.icebear2n2.userservice.domain.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "delivery")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
    @Id @GeneratedValue
    private Long deliveryId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'SHIPPED'")
    private DeliveryStatus status = DeliveryStatus.SHIPPED;
    private Timestamp estimatedArrival;
    private Timestamp actualArrival;
    private String courierName;
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }

    public void setActualArrival(Timestamp actualArrival) {
        this.actualArrival = actualArrival;
    }
}
