package org.example._4_filters_demo_2.flters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class RequestLoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        System.out.println("Request URL: " + httpRequest.getRequestURI()+" strated");
        chain.doFilter(request, response);
        System.out.println("Request URL: " + httpRequest.getRequestURI()+" ended");
    }
}
