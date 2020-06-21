package com.management.spring.security.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public String loginSuccess(){
            return "success";
        }

    @RequestMapping("error")
    public String loginError(){
        return "error";
    }

    }

