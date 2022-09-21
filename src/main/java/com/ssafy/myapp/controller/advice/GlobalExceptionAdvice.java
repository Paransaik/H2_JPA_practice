package com.ssafy.myapp.controller.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		e.printStackTrace();
//		return ResponseEntity.internalServerError().body(e.getMessage());
		return ResponseEntity.internalServerError()
				.header("Content-Type", "text/plain;charset=UTF-8")
				.body("서비스 실행 중 문제가 발생하였습니다.\n"+e.getMessage());
	}
	
	
	
	
}
