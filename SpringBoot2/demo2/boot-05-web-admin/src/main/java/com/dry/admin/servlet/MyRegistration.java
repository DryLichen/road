package com.dry.admin.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

// @Configuration
// public class MyRegistration {
//     @Bean
//     public ServletRegistrationBean myServlet(){
//         MyServlet myServlet = new MyServlet();
//         return new ServletRegistrationBean(myServlet, "/my");
//     }
//
//     @Bean
//     public FilterRegistrationBean myFilter(){
//         MyFilter myFilter = new MyFilter();
//         FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
//         filterRegistrationBean.setUrlPatterns(Arrays.asList("/my"));
//         return filterRegistrationBean;
//     }
//
//     @Bean
//     public ServletListenerRegistrationBean myListener(){
//         MyListener myListener = new MyListener();
//         return new ServletListenerRegistrationBean(myListener);
//     }
// }
