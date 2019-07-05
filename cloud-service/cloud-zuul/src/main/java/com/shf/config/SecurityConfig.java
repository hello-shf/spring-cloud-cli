package com.shf.config;

import com.alibaba.fastjson.JSON;
import com.shf.security.CustomAuthenticationEntryPoint;
import com.shf.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/2 18:09
 * @Version V1.0
 **/
@Configuration
@EnableOAuth2Sso
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http
                .authorizeRequests()
                    .antMatchers("/sso/**", "/login")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
                    .and()
                .logout()
                    .logoutSuccessUrl("http://localhost:8090/portal/sso/logout")
                    .and()
                .exceptionHandling()
                    .accessDeniedHandler(accessDeniedHandler())
                    .authenticationEntryPoint(customAuthenticationEntryPoint);//这个东东很重要，牵扯到未登录的重定向问题
    }

    // 权限不足处理
    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return new AccessDeniedHandler() {
            @Override
            public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
                Response result = new Response();
                result.buildFailedResponse("权限不足");
                httpServletResponse.setContentType("application/json;charset=utf-8");
                PrintWriter out = httpServletResponse.getWriter();
                out.write(JSON.toJSONString(result));
                out.flush();
                out.close();
            }
        };
    }
    //登出处理
//    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new LogoutSuccessHandler() {
            /**
             * 处理登出成功的请求
             *
             * @param httpServletRequest
             * @param httpServletResponse
             * @param authentication
             * @throws IOException
             * @throws ServletException
             */
            @Override
            public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                Response result = new Response();
                result.buildFailedResponse("登出成功");
                httpServletResponse.setContentType("application/json;charset=utf-8");
                PrintWriter out = httpServletResponse.getWriter();
                out.write(JSON.toJSONString(result));
                out.flush();
                out.close();
            }
        };
    }
}
