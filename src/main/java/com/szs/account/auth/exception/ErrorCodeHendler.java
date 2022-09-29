package com.szs.account.auth.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ErrorCodeHendler {

    @ExceptionHandler({ErrorCodeException.class})
    public ResponseEntity<ErrorCodeDto> exceptionHandler(final ErrorCodeException e) {
        // e.printStackTrace();
        return ResponseEntity
                .status(e.getError().getStatus())
                .body(ErrorCodeDto.builder()
                        .errorMessage(e.getError().getMessage())
                        .build());
    }

}
