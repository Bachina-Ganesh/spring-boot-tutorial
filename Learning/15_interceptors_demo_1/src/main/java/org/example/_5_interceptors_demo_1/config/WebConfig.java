package org.example._5_interceptors_demo_1.config;

import org.example._5_interceptors_demo_1.interceptors.AuthInterceptor;
import org.example._5_interceptors_demo_1.interceptors.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final AuthInterceptor authInterceptor;
    private final LogInterceptor logInterceptor;

    public WebConfig(AuthInterceptor authInterceptor, LogInterceptor logInterceptor) {
        this.authInterceptor = authInterceptor;
        this.logInterceptor = logInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/orders")
                .order(1);

        registry.addInterceptor(logInterceptor)
                .addPathPatterns("/orders")
                .order(2);
    }
}
