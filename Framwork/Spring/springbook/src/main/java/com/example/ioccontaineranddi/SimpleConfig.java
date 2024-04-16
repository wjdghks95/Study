package com.example.ioccontaineranddi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
@PropertySource(name = "myPropertySource", value = {"classpath:/database.properties", "classpath:/settings.properties"})
public class SimpleConfig {

    @Autowired Hello2 hello;

    @Bean
    Hello2 hello() {
        return new Hello2();
    }

    @Autowired
    Environment env;

    @Value("${db.username}")
    private String username;

    private String adminEmail;

    @PostConstruct
    public void init() {
        this.adminEmail = env.getProperty("admin.email");
    }

    // Environment를 사용한 프로퍼티 소스 사용
    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setUsername(env.getProperty("db.username"));

        return dataSource;
    }

    // @Value에 치환자를 사용하기위해서는 PropertySourcesPlaceholderConfigurer 빈이 등록되어 있어야 한다.
    // 반드시 static 메소드로 등록해야 한다.
    // xml에서 <context:property-placeholder />를 적용한 것과 같다.
    @Bean
    public static PropertySourcesPlaceholderConfigurer pspc() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
