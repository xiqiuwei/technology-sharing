package com.management.spring.security.security.config;

import com.management.spring.security.security.filter.VerifyFilter;
import com.management.spring.security.security.handler.*;
import com.management.spring.security.security.userdetail.CustomAuthenticationDetailsSource;
import com.management.spring.security.security.filter.MyUsernamePasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author xiqiuwei
 * @Date Created in 22:45 2019/10/28
 * @Description
 * @Modified By:
 */

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private MyAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private MyAuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private MyAuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private MyLogoutSuccessHandler logoutSuccessHandler;
    @Autowired
    private CustomAuthenticationDetailsSource customAuthenticationDetailsSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/getVerifyCode","/security/hello","login.html").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                //这里必须要写formLogin()，不然原有的UsernamePasswordAuthenticationFilter不会出现，也就无法配置我们重新的UsernamePasswordAuthenticationFilter
                .formLogin().loginPage("/security/hello")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
               // .loginProcessingUrl("/security/success")
                .authenticationDetailsSource(customAuthenticationDetailsSource)
                .and()
                .addFilterBefore(new VerifyFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterAt(myUsernamePasswordAuthenticationFilter(),UsernamePasswordAuthenticationFilter.class)
                .logout().logoutSuccessHandler(logoutSuccessHandler)
                .permitAll()
                .and()
                .csrf().disable();
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler); // 没有权限访问
        http.httpBasic().authenticationEntryPoint(authenticationEntryPoint);
       // http.addFilter(myUsernamePasswordAuthenticationFilter());
//        http.authorizeRequests()
//                .antMatchers("/base/**").permitAll();
        /**
         *  .httpBasic()
         *                 .authenticationEntryPoint(authenticationEntryPoint)
         *                 .and()
         *                 .antMatcher("/**")
         *                 .authorizeRequests()
         *                 .and()
         */


    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public MyUsernamePasswordAuthenticationFilter myUsernamePasswordAuthenticationFilter() throws Exception {
        MyUsernamePasswordAuthenticationFilter filter = new MyUsernamePasswordAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**", "/static/**", "/public/**", "/webui/**", "/h2-console/**"
                        , "/configuration/**", "/swagger-resources/**", "/api-docs", "/api-docs/**", "/v2/api-docs/**"
                        , "/**/*.css", "/**/*.js", "/**/*.ftl", "/**/*.png ", "/**/*.jpg", "/**/*.gif ", "/**/*.svg", "/**/*.ico", "/**/*.ttf", "/**/*.woff");
    }

}
