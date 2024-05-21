package com.example.springbook2.etc;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableCaching
//@Import(HelloConfig.class)
//@EnableHello(name = "Toby")
@EnableHello(mode = "mode1")
//public class AppConfig extends HelloConfig{
public class AppConfig implements HelloConfigurer{

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }

    @Override
    public void configName(Hello hello) {
        hello.setName("Toby");
    }

//    @Override
//    public Hello hello() {
//        Hello hello = super.hello();
//        hello.setName("Toby");
//        return hello;
//    }
}
