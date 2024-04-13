package com.example.ioccontaineranddi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {

    @Bean
    public Hello hello() {
        Hello hello = new Hello();
        hello.setName("Spring");
        hello.setPrinter(printer()); // DI를 위해 printer() 메소드를 여러번 호출해도 매번 동일한 오브젝트를 돌려받는다.
        return hello;
    }

    @Bean Hello hello2() {
        Hello hello = new Hello();
        hello.setName("Spring2");
        hello.setPrinter(printer());
        return hello;
    }

    // 디폴트 메타정보 항목에 따라 이 메소드로 정의되는 빈은 싱글톤이다.
    // 스프링의 특별한 조작을 통해 컨테이너에 등록된 HelloConfig 빈의 printer() 메소드는 매번 동일한 인스턴스를 리턴하도록 만들어진다.
    @Bean
    public Printer printer() {
        return new StringPrinter();
    }
}
