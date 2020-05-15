package com.management.spring.security.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.spring.security.security.entity.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author xiqiuwei
 * @Date Created in 22:43 2020/5/13
 * @Description 登录失败
 * @Modified By:
 */
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ObjectMapper json = new ObjectMapper();
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse
                .getWriter()
                .write(json.writeValueAsString(ResponseEntity.fail("未登录成功",10012)));
    }
}
