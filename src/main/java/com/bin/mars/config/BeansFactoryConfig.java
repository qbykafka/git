package com.bin.mars.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class BeansFactoryConfig {
    /**
     * 设置匹配*.htm
     * @param dispatcherServlet
     * @return
     */
   /* @Bean
    public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {
        return new ServletRegistrationBean<>(dispatcherServlet,true,"*.htm");
    }*/
}
