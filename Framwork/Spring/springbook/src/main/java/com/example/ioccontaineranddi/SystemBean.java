package com.example.ioccontaineranddi;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.util.Properties;

public class SystemBean {

    @Autowired
//    @Resource
    ApplicationContext context; // 타입에 의한 자동와이어링을 통해 애플리케이션 컨텍스트를 직접 DI 받는다. @Resource를 사용해도 된다.

    @Autowired
    BeanFactory beanFactory;

    @Autowired
    ResourceLoader resourceLoader;

    @javax.annotation.Resource
    Properties systemProperties;

    @Value("#{systemProperties['os.name']}")
    String osName;

    @Value("#{systemEnvironment['path']}")
    String path;

    public void specialJobWithContext() {
//        this.context.getBean() // 애플리케이션 컨텍스트를 직접 사용하는 코드를 작성할 수 있다.
    }

    public void loadDataFile() {
        Resource resource = this.resourceLoader.getResource("WEB-INF/info.dat");
    }

}
