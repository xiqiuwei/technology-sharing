package com.management.spring.security.security.provider;

import com.management.spring.security.security.userdetail.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Author xiqiuwei
 * @Date Created in 22:23 2020/5/13
 * @Description
 * @Modified By:
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private MyUserDetailService myUserDetailService;

    // 权限验证
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = (String)authentication.getPrincipal(); // 用户输入的用户名
        String password = (String)authentication.getCredentials(); // 用户输入的密码
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        String encodePassword = bCrypt.encode(password);
        UserDetails userDetail = myUserDetailService.loadUserByUsername(userName);
        // matches password BCryptPasswordEncoder每次加密的字符串不一样，但是底层会对密码和slat进行分开处理对比
        if (!password.equals(userDetail.getPassword())) {
            throw new BadCredentialsException("密码错误");
        }
        boolean matches = bCrypt.matches(encodePassword, userDetail.getPassword());
        System.err.println("================"+matches);
        if (!bCrypt.matches(encodePassword,userDetail.getPassword()))
            throw new BadCredentialsException("invalid password!!! 请重新输入");
        return new UsernamePasswordAuthenticationToken(userName,password,userDetail.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
