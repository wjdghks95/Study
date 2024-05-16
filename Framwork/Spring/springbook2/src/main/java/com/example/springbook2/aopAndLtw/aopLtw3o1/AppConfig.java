package com.example.springbook2.aopAndLtw.aopLtw3o1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

@Configuration
@EnableAspectJAutoProxy
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableLoadTimeWeaving
public class AppConfig {
    @Bean MyAspect myAspect() {
        return new MyAspect();
    }
}
