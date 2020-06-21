package com.management.spring.security.security.userdetail;

import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author xiqiuwei
 * @Date Created in 17:20 2020/6/21
 * @Description 该接口用于在Spring Security登录过程中对用户的登录信息的详细信息进行填
 * @Modified By:
 */
@Component
public class CustomAuthenticationDetailsSource implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {
    @Override
    public WebAuthenticationDetails buildDetails(HttpServletRequest httpRequest) {
        return new CustomWebAuthenticationDetails(httpRequest);
    }
}
