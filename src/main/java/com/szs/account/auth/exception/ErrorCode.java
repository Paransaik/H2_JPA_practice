package com.szs.account.auth.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ErrorCode {
//
//    /*
//     * 400 BAD_REQUEST: 잘못된 요청
//     */
//    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
//
//    /*
//     * 404 NOT_FOUND: 리소스를 찾을 수 없음
//     */
//    POSTS_NOT_FOUND(HttpStatus.NOT_FOUND, "게시글 정보를 찾을 수 없습니다."),
//
//    /*
//     * 405 METHOD_NOT_ALLOWED: 허용되지 않은 Request Method 호출
//     */
//    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "허용되지 않은 메서드입니다."),
//
//    /*
//     * 500 INTERNAL_SERVER_ERROR: 내부 서버 오류
//     */
//    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "내부 서버 오류입니다."),
//
//    ;
//
//    private final HttpStatus status;
//    private final String message;

    // RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "E0001"),
    // ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED, "E0002"),
    // INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E0003"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "E0001", "권한이 없습니다."),
    EXPIREDTOKEN(HttpStatus.BAD_REQUEST, "E0002", "만료된 토큰입니다."),
    COUNTERFEIT(HttpStatus.INTERNAL_SERVER_ERROR, "E0003", "위조시도"),
    SECURITY_01(HttpStatus.UNAUTHORIZED, "S0001", "HTTP STATUS 401");

    private final HttpStatus status;
    private final String code;
    private String message;

    ErrorCode(HttpStatus status, String code) {
        this.status = status;
        this.code = code;
    }

    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

}