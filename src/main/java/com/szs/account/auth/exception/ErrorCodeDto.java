package com.szs.account.auth.exception;

import lombok.*;
import org.apache.http.HttpStatus;

@Getter
@ToString
public class ErrorCodeDto {
    private String errorCode;
    private String errorMessage;

    @Builder
    public ErrorCodeDto(HttpStatus status, String errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
