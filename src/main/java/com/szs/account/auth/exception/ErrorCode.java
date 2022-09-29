package com.szs.account.auth.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ErrorCode {

    /*
     * 400 BAD_REQUEST: 잘못된 요청
     */
    EXPIREDTOKEN(HttpStatus.BAD_REQUEST, "만료된 토큰입니다."),

    /*
     * 401
     */
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "권한이 없습니다."),

    /*
     * 500 INTERNAL_SERVER_ERROR: 내부 서버 오류
     */
    COUNTERFEIT(HttpStatus.INTERNAL_SERVER_ERROR, "위조시도");

    private final HttpStatus status;
    private final String message;

    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

}