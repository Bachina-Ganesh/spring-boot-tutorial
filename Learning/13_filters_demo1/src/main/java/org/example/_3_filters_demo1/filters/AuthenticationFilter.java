package org.example._3_filters_demo1.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@Order(1)
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        long startTime = System.currentTimeMillis();

        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        chain.doFilter(httpServletRequest, httpServletResponse);

        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println("Total time : " + totalTime);
        httpServletResponse.setHeader("X-Total-Count", String.valueOf(totalTime));

    }
}
