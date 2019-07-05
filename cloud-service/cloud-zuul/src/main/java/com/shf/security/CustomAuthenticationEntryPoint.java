package com.shf.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/4 23:24
 * @Version V1.0
 **/
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
            System.out.println("进入Entry方法");
            httpServletResponse.sendRedirect("http://localhost:8090/portal/sso/login_page");
    }
}
