package com.example.ioccontaineranddi;

import org.springframework.context.annotation.Bean;

// 일반 빈 클래스에서 사용되는 @Bean 설정정보
public class HelloService {

    private Printer printer;

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    @Bean
    public Hello hello() {
        Hello hello = new Hello();
        hello.setPrinter(this.printer);
        return hello;
    }

    @Bean Hello hello2() {
        Hello hello = new Hello();
        hello.setPrinter(this.printer);
        return hello;
    }

    // @Configuration 애노테이션이 없이 DI 설정을 위해 @Bean 메소드를 직접 호출한 경우 싱글톤 빈으로 사용되지 않는다.
    @Bean
    private Printer printer() {
        return new StringPrinter();
    }
}
