package com.icebear2n2.userservice.domain.dto;

import com.icebear2n2.userservice.domain.entity.UserWish;
import com.icebear2n2.userservice.domain.entity.UserWishProduct;
import com.icebear2n2.userservice.domain.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserWishDTO {
    private Long userWishId;
    private Long userId;
    private List<UserWishProductDTO> userWishProducts;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public UserWishDTO(UserWish userWish) {
        this.userWishId = userWish.getUserWishId();
        this.userId = userWish.getUser().getUserId();
        this.userWishProducts = userWish.getUserWishProducts().stream().map(UserWishProductDTO::new).toList();
        this.createdAt = userWish.getCreatedAt();
        this.updatedAt = userWish.getUpdatedAt();
    }
}
