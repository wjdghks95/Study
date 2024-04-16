package com.example.ioccontaineranddi;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.Properties;

import static org.junit.Assert.*;

public class ContextTest {
    @Test
    public void beanRoleTest() {
        ApplicationContext context = new GenericXmlApplicationContext("classpath:/beanrole.xml");

        SimpleConfig sc = context.getBean(SimpleConfig.class);
        sc.hello.sayHello();

        BeanDefinitionUtils.printBeanDefinitions((GenericApplicationContext) context);
    }


    @Test
    public void activeTest() {
        GenericXmlApplicationContext ac = new GenericXmlApplicationContext("classpath:/beanrole.xml");
        ac.getEnvironment().setActiveProfiles("dev");
        ac.load("classpath:/beanrole.xml");
    }

    @Test
    public void environmentTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        System.out.println(ac.getEnvironment().getProperty("os.name"));
        System.out.println(ac.getEnvironment().getProperty("Path"));

        // 프로퍼티 추가
        Properties p = new Properties();
        p.put("db.username", "spring");
        PropertySource<?> ps = new PropertiesPropertySource("customPropertySource", p);

        ac.getEnvironment().getPropertySources().addFirst(ps);
    }
}