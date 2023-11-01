package com.icebear2n2.userservice.domain.response;

import com.icebear2n2.userservice.domain.dto.UserWishProductDTO;
import com.icebear2n2.userservice.domain.entity.UserWish;
import com.icebear2n2.userservice.domain.entity.UserWishProduct;
import com.icebear2n2.userservice.domain.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserWishResponse {
    private boolean success;
    private String message;
    private UserWishData data;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserWishData {
        private Long userWishId;
        private Long userId;
        private List<UserWishProductDTO> userWishProducts;
        private Timestamp createdAt;
        private Timestamp updatedAt;

        public UserWishData(UserWish userWish) {
            this.userWishId = userWish.getUserWishId();
            this.userId = userWish.getUser().getUserId();
            this.userWishProducts = userWish.getUserWishProducts() != null ? userWish.getUserWishProducts().stream().map(UserWishProductDTO::new).toList() : null;
            this.createdAt = userWish.getCreatedAt();
            this.updatedAt = userWish.getUpdatedAt();
        }
    }

    public static UserWishResponse success(UserWish userWish) {
        return new UserWishResponse(true, "Success", new UserWishResponse.UserWishData(userWish));
    }

    public static UserWishResponse failure(String message) {
        return new UserWishResponse(false, message, null);
    }
}
