package com.example.ioccontaineranddi;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.HashMap;
import java.util.Map;

// 프로퍼티 소스를 추가하는 ApplicationContextInitializer
public class MyContextInitializer implements ApplicationContextInitializer<AnnotationConfigWebApplicationContext> {
    @Override
    public void initialize(AnnotationConfigWebApplicationContext ac) {
        ConfigurableEnvironment ce = ac.getEnvironment();

        Map<String, Object> m = new HashMap<>();
        m.put("db.username", "spring");

        ce.getPropertySources().addFirst(new MapPropertySource("myPS", m));
    }
}
