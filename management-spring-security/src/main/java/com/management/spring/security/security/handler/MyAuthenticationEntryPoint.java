package com.management.spring.security.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.spring.security.security.entity.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author xiqiuwei
 * @Date Created in 22:41 2020/5/13
 * @Description 未登录
 * @Modified By:
 */
@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ObjectMapper json = new ObjectMapper();
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse
                .getWriter()
                .write(json.writeValueAsString(ResponseEntity.fail("你没有登录",10011)));
    }
}
