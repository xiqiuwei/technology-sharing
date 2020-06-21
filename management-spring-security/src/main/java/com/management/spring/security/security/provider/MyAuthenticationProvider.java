package com.management.spring.security.security.provider;

import com.management.spring.security.security.userdetail.CustomWebAuthenticationDetails;
import com.management.spring.security.security.userdetail.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author xiqiuwei
 * @Date Created in 22:23 2020/5/13
 * @Description
 * @Modified By:
 */
@Component
@SuppressWarnings("Duplicates")
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private MyUserDetailService myUserDetailService;

    // 权限验证
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = (String)authentication.getPrincipal(); // 用户输入的用户名
        String password = (String)authentication.getCredentials(); // 用户输入的密码
        CustomWebAuthenticationDetails details = (CustomWebAuthenticationDetails) authentication.getDetails();
        System.out.println("==================="+details);
        String verifyCode = details.getVerifyCode();
        if(!validateVerify(verifyCode)) {
            throw new DisabledException("验证码输入错误");
        }
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        String encodePassword = bCrypt.encode(password);
        UserDetails userDetail = myUserDetailService.loadUserByUsername(userName);
        // matches password BCryptPasswordEncoder每次加密的字符串不一样，但是底层会对密码和slat进行分开处理对比
        boolean matches = bCrypt.matches(password,encodePassword);
        System.err.println("================"+matches);
        if (!bCrypt.matches(password,encodePassword))
            throw new BadCredentialsException("invalid password!!! 请重新输入");
        return new UsernamePasswordAuthenticationToken(userName,password,userDetail.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    private boolean validateVerify(String inputVerify) {
        //获取当前线程绑定的request对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 不分区大小写
        // 这个validateCode是在servlet中存入session的名字
        String validateCode = ((String) request.getSession().getAttribute("validateCode")).toLowerCase();

        inputVerify = inputVerify.toLowerCase();
        System.out.println("验证码：" + validateCode + "用户输入：" + inputVerify);
        return validateCode.equals(inputVerify);
    }
}
