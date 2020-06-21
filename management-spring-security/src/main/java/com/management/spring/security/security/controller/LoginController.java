package com.management.spring.security.security.controller;

import com.management.spring.security.jdbc.dataobject.User;
import com.management.spring.security.security.entity.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author xiqiuwei
 * @Date Created in 15:13 2020/6/21
 * @Description
 * @Modified By:
 */
@Controller
@RequestMapping("security")
public class LoginController {

    @GetMapping("hello")
    public String login() {
        return "login";
    }

    @RequestMapping("success")
    public void loginSuccess(HttpServletRequest request, HttpServletResponse response){
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String,String[]> entry:parameterMap.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }
}
