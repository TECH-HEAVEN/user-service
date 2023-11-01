package com.icebear2n2.userservice.UserAddress.service;

import com.icebear2n2.userservice.domain.entity.user.User;
import com.icebear2n2.userservice.domain.entity.UserAddress;
import com.icebear2n2.userservice.domain.repository.UserAddressRepository;
import com.icebear2n2.userservice.domain.repository.user.UserRepository;
import com.icebear2n2.userservice.domain.request.UpdateUserAddressRequest;
import com.icebear2n2.userservice.domain.request.UserAddressRequest;
import com.icebear2n2.userservice.domain.response.UserAddressResponse;
import com.icebear2n2.userservice.exception.ErrorCode;
import com.icebear2n2.userservice.exception.UserServiceException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAddressService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserAddressService.class);
    private final UserAddressRepository userAddressRepository;
    private final UserRepository userRepository;

    public UserAddressResponse createUserAddressInfo(UserAddressRequest userAddressRequest) {
        if (!userRepository.existsByUserId(userAddressRequest.getUserId())) {
            return UserAddressResponse.failure(ErrorCode.USER_NOT_FOUND.toString());
        }

        try {
            User user = userRepository.findById(userAddressRequest.getUserId()).orElseThrow(() -> new UserServiceException(ErrorCode.USER_NOT_FOUND));
            UserAddress userAddress = userAddressRequest.toEntity(user);
            UserAddress saveUserAddress = userAddressRepository.save(userAddress);
            return UserAddressResponse.success(saveUserAddress);
        } catch (Exception e) {
            LOGGER.info("INTERNAL_SERVER_ERROR: {}", e.toString());
            return UserAddressResponse.failure(ErrorCode.INTERNAL_SERVER_ERROR.toString());
        }
    }

    public UserAddressResponse updateUserAddressInfo(UpdateUserAddressRequest updateUserAddressRequest) {
        if (!userRepository.existsByUserId(updateUserAddressRequest.getUserId())) {
            return UserAddressResponse.failure(ErrorCode.USER_NOT_FOUND.toString());
        }

        if (!userAddressRepository.existsByUserAddressId(updateUserAddressRequest.getUserAddressId())) {
            return UserAddressResponse.failure(ErrorCode.USER_ADDRESS_INFORMATION_NOT_FOUND.toString());
        }

        try {
            UserAddress userAddress = userAddressRepository.findById(updateUserAddressRequest.getUserAddressId()).orElseThrow(() -> new UserServiceException(ErrorCode.USER_ADDRESS_INFORMATION_NOT_FOUND));
            updateUserAddressRequest.updateUserAddressInfoIfNotNull(userAddress);

            UserAddress updateUserAddress = userAddressRepository.save(userAddress);

            return UserAddressResponse.success(updateUserAddress);
        } catch (Exception e) {
            LOGGER.info("INTERNAL_SERVER_ERROR: {}", e.toString());
            return UserAddressResponse.failure(ErrorCode.INTERNAL_SERVER_ERROR.toString());
        }
    }

    public void removeUserAddressInfo(Long userAddressId) {
        UserAddress userAddress = userAddressRepository.findById(userAddressId).orElseThrow(() -> new UserServiceException(ErrorCode.USER_ADDRESS_INFORMATION_NOT_FOUND));
        User user = userAddress.getUser();

        if (!userAddressRepository.findByUser(user)) {
            throw new  UserServiceException(ErrorCode.INVALID_USER);
        }

        try {
            userAddressRepository.deleteById(userAddressId);

        } catch (Exception e) {
            LOGGER.info("INTERNAL_SERVER_ERROR: {}", e.toString());
            throw new  UserServiceException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }
}
