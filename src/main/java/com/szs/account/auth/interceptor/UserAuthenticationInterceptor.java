package com.szs.account.auth.interceptor;

import com.szs.account.bu.api.service.JwtServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.security.Key;

@Component
public class UserAuthenticationInterceptor implements HandlerInterceptor {

    public static final Logger logger = LoggerFactory.getLogger(JwtServiceImpl.class);

    private static final int EXPIRE_MINUTES = 60;
    private static final String HEADER_AUTH = "token";

    public static void main(String[] args) {
        String expire = "1672488000000";

        Claims claims = Jwts.claims();
        claims.put("id", 1);
        claims.put("expire", expire);

//        new Buffer('{"iss":"John Doe","exp":1434290400000,"username":"john","age":25,"iat":1434286842654}').toString("base64");
//        String jwt = Jwts
//                .builder()
//                .setClaims(claims)
//                .setHeaderParam("typ", "JWT")
//                .toString("base64");

    }

//    private Key getSigninKey() {
//        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
//        return Keys.hmacShaKeyFor(keyBytes);
//    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // TODO 인증 토큰 처리 구현
        String jwt = Jwts
                .builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("regDate", System.currentTimeMillis())
//                .setPayload
                .setSubject(HEADER_AUTH).claim("expire", "1672488000000")
//                .setSubject(HEADER_AUTH).claim("id", request.getAttribute("id"))
//                .setSubject(HEADER_AUTH).claim("expire", request.getAttribute("expire"))
                .compact();
        System.out.println(jwt);
        return true;
    }

}
