package com.szs.account.auth.interceptor;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.szs.account.auth.AuthorizedUser;
import com.szs.account.auth.exception.ErrorCode;
import com.szs.account.auth.exception.ErrorCodeException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.regex.Pattern;

@Component
public class UserAuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // TODO 인증 토큰 처리 구현
        /*System.out.println(request);
        String base64Token = request.getHeader("Authorization");
        String reg = "Bearer ([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$";

        // Test 01:: 401 UNAUTHORIZED
        if (base64Token == null) throw new ErrorCodeException(ErrorCode.UNAUTHORIZED);
        // Test 02, 04:: 401 UNAUTHORIZED
        if (!Pattern.matches(reg, base64Token)) throw new ErrorCodeException(ErrorCode.UNAUTHORIZED);

        Optional<byte[]> token = Optional.ofNullable(DatatypeConverter.parseBase64Binary(base64Token.split(" ")[1]));
        String stringToken = new String(token.get(), StandardCharsets.UTF_8);

        JsonElement element = JsonParser.parseString(stringToken);
        AuthorizedUser authorizedUser =
                new AuthorizedUser(element.getAsJsonObject().get("id").getAsLong(),
                        element.getAsJsonObject().get("expire").getAsLong());

        // Test 03:: 401 UNAUTHORIZED
        if (authorizedUser.isExpired()) throw new ErrorCodeException(ErrorCode.UNAUTHORIZED);
        request.setAttribute("authorizedUser", authorizedUser);*/
        return true;
    }

}
