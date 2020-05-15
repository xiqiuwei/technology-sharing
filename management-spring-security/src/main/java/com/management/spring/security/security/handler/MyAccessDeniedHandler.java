package com.management.spring.security.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.spring.security.security.entity.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author xiqiuwei
 * @Date Created in 22:49 2020/5/13
 * @Description 无权访问
 * @Modified By:
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        ObjectMapper json = new ObjectMapper();
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse
                .getWriter()
                .write(json.writeValueAsString(ResponseEntity.fail("你无权访问",10010)));
    }
}
