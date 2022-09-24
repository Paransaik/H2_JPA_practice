package com.szs.account.auth.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

@Component
public class UserAuthenticationInterceptor implements HandlerInterceptor {

//    public static void main(String[] args) {
//        byte[] token = request.getHeader("Authorization").getBytes("UTF-8");
//        String encoded = DatatypeConverter.printBase64Binary(token);
//        System.out.println(encoded);
//    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // TODO 인증 토큰 처리 구현
        byte[] token = request.getHeader("Authorization").getBytes("UTF-8");
        String encoded = DatatypeConverter.printBase64Binary(token);
        System.out.println(encoded);
        return true;
    }

}
