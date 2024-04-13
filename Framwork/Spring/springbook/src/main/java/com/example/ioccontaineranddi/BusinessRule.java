package com.example.ioccontaineranddi;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component // @Component를 메타 애노테이션으로 선언해주면 빈 스캐너 디폴트 필터의 자동인식 대상이 된다.
public @interface BusinessRule {
    String value() default ""; // 빈의 아이디를 직접 지정할 수 있도록 디폴트 엘리먼트를 선언해둔다.
}
