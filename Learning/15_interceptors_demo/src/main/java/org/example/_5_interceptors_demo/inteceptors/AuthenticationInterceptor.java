package org.example._5_interceptors_demo.inteceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String api_key = request.getHeader("X-Api-Key");
        System.out.println(api_key);

        if(api_key == null || !api_key.equals("secret123")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("""
                    {
                    "message": "User is unauthorized"
                    }
                    """);
            return false;
        }
        return true;
    }
}
