package com.example.ioccontaineranddi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Value("${db.username}")
    private String name;

    // 애노테이션에 의한 의존관계 설정 @Autowired, @Resource
    @Bean
    public Hello hello1() {
        return new Hello();
    }

    // 메소드 호출을 이용한 의존관계 설정
    // 자바 코드 설정에 사용하는 @Value
    @Bean
    public Hello hello2() {
        Hello hello = new Hello();
        hello.setName(this.name);
        hello.setPrinter(printer());
        return hello;
    }

    // @Bean 메소드 자동와이어링을 이용한 의존관계 설정
    // 메소드 파라미터에 적용한 @Value
    @Bean
    public Hello hello3(@Value("${db.username}") String name, Printer printer) {
        Hello hello = new Hello();
        hello.setName(name);
        hello.setPrinter(printer);
        return hello;
    }

    @Bean
    public Printer printer() {
        return new StringPrinter();
    }
}
