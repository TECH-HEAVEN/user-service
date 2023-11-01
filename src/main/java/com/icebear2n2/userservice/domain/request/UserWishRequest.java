package com.icebear2n2.userservice.domain.request;

import com.icebear2n2.userservice.domain.entity.UserWish;
import com.icebear2n2.userservice.domain.entity.UserWishProduct;
import com.icebear2n2.userservice.domain.entity.product.Product;
import com.icebear2n2.userservice.domain.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collections;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserWishRequest {
    private Long userId;
    private Long userWishId;
    private Long productId;

    public UserWish toEntity(User user, Product product) {

        UserWish userWish = UserWish.builder()
                .user(user)
                .build();

        UserWishProduct userWishProduct = UserWishProduct.builder()
                .userWish(userWish)
                .product(product)
                .build();

        userWish.setUserWishProducts(Collections.singletonList(userWishProduct));
        return userWish;
    }
}
