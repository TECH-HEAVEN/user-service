package com.icebear2n2.userservice.domain.dto;

import com.icebear2n2.userservice.domain.entity.UserWishProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserWishProductDTO {
    private Long userWishProductId;
    private UserWishDTO userWish;
    private ProductDTO product;

    public UserWishProductDTO(UserWishProduct userWishProduct) {
        this.userWishProductId = userWishProduct.getUserWishProductId();
        this.userWish = new UserWishDTO(userWishProduct.getUserWish());
        this.product = new ProductDTO(userWishProduct.getProduct());
    }
}
