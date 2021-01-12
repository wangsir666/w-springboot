package com.cloud.springboot.Listener;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @auther: wjx
 * @Date: 2021/1/7 16:31
 * @Description:
 */
@WebFilter(urlPatterns = "/*")
@Component
public class HelloFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("hello fileter -----doFilter");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("hello fileter -----init");
    }

    @Override
    public void destroy() {
        System.out.println("hello fileter -----destroy");
    }
}
