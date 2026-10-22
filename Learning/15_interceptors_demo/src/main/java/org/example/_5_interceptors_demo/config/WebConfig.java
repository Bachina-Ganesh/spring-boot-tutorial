package org.example._5_interceptors_demo.config;

import org.example._5_interceptors_demo.inteceptors.AuthenticationInterceptor;
import org.example._5_interceptors_demo.inteceptors.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final LoggingInterceptor loggingInterceptor;
    private final AuthenticationInterceptor authenticationInterceptor;

    public WebConfig(LoggingInterceptor loggingInterceptor, AuthenticationInterceptor authenticationInterceptor) {
        this.loggingInterceptor = loggingInterceptor;
        this.authenticationInterceptor = authenticationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingInterceptor)
                .addPathPatterns("/orders")
                .excludePathPatterns("/login")
                .order(2);
        registry.addInterceptor(authenticationInterceptor)
                .order(1);
    }
}
