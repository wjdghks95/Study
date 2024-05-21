package com.example.springbook2.etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//public class HelloConfig implements ImportAware {
public class HelloConfig2 {

    @Autowired HelloConfigurer helloConfigurer;

    @Bean
    public Hello hello() {
        Hello h = new Hello();
        h.setName("Spring");
        helloConfigurer.configName(h);
        return h;
    }

//    @Override
//    public void setImportMetadata(AnnotationMetadata annotationMetadata) {
//        Map<String, Object> elements = annotationMetadata.getAnnotationAttributes(EnableHello.class.getName());
//        String name = (String) elements.get("name");
//        hello().setName(name);
//    }
}
