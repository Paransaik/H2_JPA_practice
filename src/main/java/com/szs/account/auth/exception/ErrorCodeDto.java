package com.szs.account.auth.exception;

import lombok.*;
import org.apache.http.HttpStatus;

@Getter
@ToString
public class ErrorCodeDto {

    public final HttpStatus status;
    private final String errorMessage;

    @Builder
    public ErrorCodeDto(HttpStatus status, String errorMessage){
        this.status = status;
        this.errorMessage = errorMessage;
    }

}
