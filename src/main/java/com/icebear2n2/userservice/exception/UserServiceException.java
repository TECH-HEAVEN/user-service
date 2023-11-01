package com.icebear2n2.userservice.exception;

import lombok.Getter;

@Getter
public class UserServiceException extends RuntimeException {
    private final ErrorCode errorCode;
    private final String message;

    public UserServiceException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }
}
