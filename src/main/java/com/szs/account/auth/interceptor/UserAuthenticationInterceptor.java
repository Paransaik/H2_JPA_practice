package com.szs.account.auth.interceptor;

import com.szs.account.auth.AuthorizedUser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

@Component
public class UserAuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // TODO 인증 토큰 처리 구현
        byte[] token = DatatypeConverter.parseBase64Binary(request.getHeader("Authorization").split(" ")[1]);
        String[] idAndExpire = new String(token, "UTF-8")
                .replaceAll("\n", " ")
                .replaceAll("[^\\d\\s]", "")
                .replaceAll("\\s{2,}", " ")
                .split(" ");


/*
*
*   Map<String, Object> map = new HashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");

        Gson gson = new Gson();
        JsonObject json = gson.toJsonTree(map).getAsJsonObject();

        System.out.printf( "JSON: %s", json);
        *
* */
        AuthorizedUser authorizedUser = new AuthorizedUser(Long.parseLong(idAndExpire[1]), Long.parseLong(idAndExpire[2]));
        request.setAttribute("authorizedUser", authorizedUser);
        return true;
    }

}
