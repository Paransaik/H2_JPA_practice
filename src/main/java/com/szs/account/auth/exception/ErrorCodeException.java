package com.szs.account.auth.exception;

import lombok.Getter;

@Getter
public class ErrorCodeException extends Exception {
    private ErrorCode error;

    public ErrorCodeException(ErrorCode e) {
        super(e.getMessage());
        this.error = e;
    }

}
