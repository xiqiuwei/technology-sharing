package com.management.spring.security.security.controller;

import com.management.spring.security.security.entity.AuthenticationBean;
import com.management.spring.security.security.entity.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xiqiuwei
 * @Date Created in 23:53 2020/5/14
 * @Description
 * @Modified By:
 */
@RestController
public class SpringSecurityController {

    @PostMapping("/login/token")
    public ResponseEntity login(@RequestBody AuthenticationBean authenticationBean) {
        System.out.println(authenticationBean.getUsername());
        System.out.println(authenticationBean.getPassword());
        return null;
    }

    @GetMapping("/mytest")
    public String success(){
        return "成功";
    }
}
