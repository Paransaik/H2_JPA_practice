package com.szs.account.auth.interceptor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.szs.account.auth.AuthorizedUser;
import com.szs.account.auth.exception.ErrorCode;
import com.szs.account.auth.exception.ErrorCodeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.util.HashMap;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserAuthenticationInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthenticationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // TODO 인증 토큰 처리 구현
        // Test 04, :: 401 UNAUTHORIZED
        String base64Token = request.getHeader("Authorization");
        String reg = "Bearer " + "([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$";

        if (base64Token == null) throw new ErrorCodeException(ErrorCode.SECURITY_01);
        if (!Pattern.matches(reg, base64Token)) throw new ErrorCodeException(ErrorCode.SECURITY_01);

        Optional<?> auth = Optional.ofNullable(base64Token);

        // Test 01:: 401 UNAUTHORIZED
        if (!auth.isPresent()) throw new ErrorCodeException(ErrorCode.SECURITY_01);

        Optional<byte[]> token = Optional.ofNullable(DatatypeConverter.parseBase64Binary(request.getHeader("Authorization").split(" ")[1]));
        String stringToken = new String(token.get(), "UTF-8");

//        ObjectMapper mapper = new ObjectMapper();
//        Optional<HashMap<String, String>> map = Optional.ofNullable(mapper.readValue(stringToken, new TypeReference<HashMap<String, String>>() {}));
//        if (!map.isPresent()) throw new ErrorCodeException(ErrorCode.SECURITY_01);
//        AuthorizedUser authorizedUser = new AuthorizedUser(
//                Long.parseLong(String.valueOf(map.get().get("id"))), Long.parseLong(String.valueOf(map.get().get("expire"))));

        JsonElement element = JsonParser.parseString(stringToken);
        AuthorizedUser authorizedUser =
                new AuthorizedUser(element.getAsJsonObject().get("id").getAsLong(),
                        element.getAsJsonObject().get("expire").getAsLong());

        logger.info(String.valueOf(authorizedUser));

        request.setAttribute("authorizedUser", authorizedUser);
        return true;
    }

}
