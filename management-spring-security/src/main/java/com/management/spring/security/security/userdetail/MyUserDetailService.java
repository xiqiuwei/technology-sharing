package com.management.spring.security.security.userdetail;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author xiqiuwei
 * @Date Created in 22:45 2020/5/12
 * @Description
 * @Modified By:
 */

@Component
public class MyUserDetailService implements UserDetailsService {
    //前后端交互的时候去数据库查用户的信息的方法
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        MyUserDetail myUserDetail = new MyUserDetail();
        myUserDetail.setUserName(s);
        // 我这里假设根据用户名从数据库取出了对应的密码
        // 对用户密码进行再次加密（我此处省略了对密码的加密操作了比如AES RSA都可以）
        String password = "12345";
        myUserDetail.setPassword(password);
        Set<GrantedAuthority> set = new HashSet<>();
        // 这里我也模拟了下数据库角色了正常都是需要去查权限的
        GrantedAuthority grantedAuthority = (GrantedAuthority) () -> "ADMIN";
        set.add(grantedAuthority);
        myUserDetail.setAuthorities(set);
        return myUserDetail;
    }

    public static void main(String[] args) {
        String password = "12345";
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        String encode = bCrypt.encode(password);
        System.err.println(encode);

        boolean matches = bCrypt.matches("12345", encode);
        System.err.println(matches);
    }
}
