package com.icebear2n2.userservice.domain.entity;

import com.icebear2n2.userservice.domain.entity.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_wish_product")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserWishProduct {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userWishProductId;

    @ManyToOne
    @JoinColumn(name = "user_wish_id")
    private UserWish userWish;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public void setUserWish(UserWish userWish) {
        this.userWish = userWish;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
