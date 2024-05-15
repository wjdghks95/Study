package com.example.springbook2.mvc.enableWebMvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new MyWebMvcConfigurer();
    }

//    @Bean
//    public WebMvcConfigurer securityConfigurer() {
//        return new SecurityConfigurer();
//    }

//    @Bean
//    public WebMvcConfigurer customerHandlerConfigurer() {
//        return new CustomerHandlerConfigurer();
//    }
}
