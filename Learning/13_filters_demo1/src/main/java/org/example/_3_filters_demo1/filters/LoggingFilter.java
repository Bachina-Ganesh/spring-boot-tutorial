package org.example._3_filters_demo1.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse  httpServletResponse = (HttpServletResponse) response;

        System.out.println("Api Request : "+httpServletRequest.getMethod()+" "+httpServletRequest.getRequestURI()+" started");
        chain.doFilter(request, response);
        System.out.println("Api Request : "+httpServletRequest.getMethod()+" "+httpServletRequest.getRequestURI()+" finished");
    }
}

/**
 * Log the Request & Response
 * Find total time taken by request to be completed
 * Authentication
 * Generate Request I'd
 */