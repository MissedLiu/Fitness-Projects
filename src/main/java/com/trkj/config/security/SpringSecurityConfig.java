package com.trkj.config.security;

import com.trkj.config.security.filter.CheckTokenFilter;
import com.trkj.config.security.handler.AnonymousAuthenticationHandler;
import com.trkj.config.security.handler.CustomerAccessDeniedHandler;
import com.trkj.config.security.handler.LoginFailureHandler;
import com.trkj.config.security.handler.LoginSuccessHandler;
import com.trkj.config.security.service.CustomerUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity//开启Security的使用
//开启权限注解控制
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private LoginSuccessHandler loginSuccessHandler;
    @Resource
    private LoginFailureHandler loginFailureHandler;
    @Resource
    private CustomerAccessDeniedHandler customerAccessDeniedHandler;
    @Resource
    private AnonymousAuthenticationHandler anonymousAuthenticationHandler;
    @Resource
    private CustomerUserDetailsService customerUserDetailsService;
    @Resource
    private CheckTokenFilter checkTokenFilter;

    /*
     * 注入加密类
     * */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
     * 登录处理认证
     * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //登录前进行过滤
        http.addFilterBefore(checkTokenFilter, UsernamePasswordAuthenticationFilter.class);
        //登录过程处理
        http.formLogin()   //表单验证
                .loginProcessingUrl("/api/user/login")//登录请求url,自定义即可
                .successHandler(loginSuccessHandler)  //认证成功处理器
                .failureHandler(loginFailureHandler)  //认证失败处理器
                .usernameParameter("username")//默认为username可不写,否则要写
                .and()
                .csrf().disable()// 禁用csrf防御机制
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//不创建session
                .and()
                .authorizeHttpRequests()//设置需要拦截的请求
                .antMatchers("/api/user/login").permitAll() //登录请求放行(不拦截)
                .anyRequest().authenticated() //其他一律需要通过身份验证
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(anonymousAuthenticationHandler)//匿名无权限访问
                .accessDeniedHandler(customerAccessDeniedHandler)//认证用户无权限访问
                .and()
                .cors();//支持跨域请求


    }

    /*
     * 配置认证处理器
     * */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customerUserDetailsService).passwordEncoder(passwordEncoder());
    }


}
