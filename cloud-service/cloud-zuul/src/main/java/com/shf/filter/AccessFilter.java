package com.shf.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/3 17:30
 * @Version V1.0
 **/
@Component
@Slf4j
public class AccessFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        log.info("请求的url----->{}", request.getRequestURL());
        log.info("请求的URI----->{}", request.getRequestURI());
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
