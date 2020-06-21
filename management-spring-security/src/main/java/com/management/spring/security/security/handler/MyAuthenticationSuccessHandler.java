package com.management.spring.security.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.spring.security.security.entity.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author xiqiuwei
 * @Date Created in 22:42 2020/5/13
 * @Description 登录成功
 * @Modified By:
 */
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        ObjectMapper json = new ObjectMapper();
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse
                .getWriter()
                .write(json.writeValueAsString(ResponseEntity.success("登录成功")));
    }
}
