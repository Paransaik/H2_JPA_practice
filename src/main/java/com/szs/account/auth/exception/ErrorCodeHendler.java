package com.szs.account.auth.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class ErrorCodeHendler {

    @ExceptionHandler({ErrorCodeException.class})
    public ResponseEntity<ErrorCodeDto> exceptionHandler(HttpServletRequest request, final ErrorCodeException e) {
        //e.printStackTrace();
        return ResponseEntity
                .status(e.getError().getStatus())
                .body(ErrorCodeDto.builder()
                        .errorCode(e.getError().getCode())
                        .errorMessage(e.getError().getMessage())
                        .build());
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ErrorCodeDto> exceptionHandler(HttpServletRequest request, final RuntimeException e) {
        e.printStackTrace();
        return ResponseEntity
                .status(ErrorCode.EXPIREDTOKEN.getStatus())
                .body(ErrorCodeDto.builder()
                        .errorCode(ErrorCode.EXPIREDTOKEN.getCode())
                        .errorMessage(e.getMessage())
                        .build());
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<ErrorCodeDto> exceptionHandler(HttpServletRequest request, final AccessDeniedException e) {
        e.printStackTrace();
        return ResponseEntity
                .status(ErrorCode.UNAUTHORIZED.getStatus())
                .body(ErrorCodeDto.builder()
                        .errorCode(ErrorCode.UNAUTHORIZED.getCode())
                        .errorMessage(e.getMessage())
                        .build());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorCodeDto> exceptionHandler(HttpServletRequest request, final Exception e) {
        e.printStackTrace();
        return ResponseEntity
                .status(ErrorCode.COUNTERFEIT.getStatus())
                .body(ErrorCodeDto.builder()
                        .errorCode(ErrorCode.COUNTERFEIT.getCode())
                        .errorMessage(e.getMessage())
                        .build());
    }

}
