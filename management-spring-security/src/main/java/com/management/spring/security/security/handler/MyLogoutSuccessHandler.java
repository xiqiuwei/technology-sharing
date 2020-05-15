package com.management.spring.security.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.spring.security.security.entity.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author xiqiuwei
 * @Date Created in 22:48 2020/5/13
 * @Description 注销
 * @Modified By:
 */
@Component
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        ObjectMapper json = new ObjectMapper();
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse
                .getWriter()
                .write(json.writeValueAsString(ResponseEntity.fail("退出成功",10014)));
    }
}
