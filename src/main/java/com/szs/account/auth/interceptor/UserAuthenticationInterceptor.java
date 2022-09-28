package com.szs.account.auth.interceptor;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.szs.account.auth.AuthorizedUser;
import org.apache.http.HttpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.util.Optional;

@Component
public class UserAuthenticationInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthenticationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // TODO 인증 토큰 처리 구현
        Optional<?> auth = Optional.ofNullable(request.getHeader("Authorization"));
        // test 01
//        if (!auth.isPresent()) throw new HttpException();
        if (!auth.isPresent()) throw new Exception(String.valueOf(HttpStatus.UNAUTHORIZED));
        Optional<byte[]> token = Optional.ofNullable(DatatypeConverter.parseBase64Binary(request.getHeader("Authorization").split(" ")[1]));
        System.out.println(token.isPresent());
        String stringToken = new String(token.get(), "UTF-8");
        logger.info(stringToken);

        if (stringToken.equals("")) {
            logger.info(stringToken);
            throw new Exception("??");
//            throw new ErrorCodeException(ErrorCode.UNAUTHORIZED);
        }

        JsonElement element = JsonParser.parseString(stringToken);
        AuthorizedUser authorizedUser =
                new AuthorizedUser(element.getAsJsonObject().get("id").getAsLong(),
                        element.getAsJsonObject().get("expire").getAsLong());
        request.setAttribute("authorizedUser", authorizedUser);
        return true;
    }

}
