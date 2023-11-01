package com.icebear2n2.userservice.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "user_address")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAddress {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userAddressId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String receiverPhone;
    private String receiverName;
    private String postCode;
    private String address;
    private String addressDetail;
    private String addressExtra;
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;

}
