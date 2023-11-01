package com.icebear2n2.userservice.domain.entity;

import com.icebear2n2.userservice.domain.entity.product.Product;
import com.icebear2n2.userservice.domain.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "user_wish")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserWish {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userWishId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "userWish")
    private List<UserWishProduct> userWishProducts;
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;

    public void setUserWishProducts(List<UserWishProduct> userWishProducts) {
        this.userWishProducts = userWishProducts;
    }
}
