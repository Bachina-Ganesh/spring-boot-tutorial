package org.example._4_filters_demo_2.config;

import org.example._4_filters_demo_2.flters.RequestLoggingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

//    @Bean
//    public FilterRegistrationBean<RequestLoggingFilter> filterRegistrationBean() {
//        FilterRegistrationBean<RequestLoggingFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new RequestLoggingFilter());
//        registrationBean.addUrlPatterns("/orders");
//        return registrationBean;
//    }
}
