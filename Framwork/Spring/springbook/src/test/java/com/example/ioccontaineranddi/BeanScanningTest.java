package com.example.ioccontaineranddi;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class BeanScanningTest {

    @Test
    public void simpleBeanScanning() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.example.ioccontaineranddi");
        AnnotatedHello hello = ctx.getBean("annotatedHello", AnnotatedHello.class);

        assertThat(hello, is(notNullValue()));

        // @Configuration 클래스를 이용하는 컨텍스트 테스트
        ctx = new AnnotationConfigApplicationContext(AnnotatedHelloConfig.class);
        hello = ctx.getBean("annotatedHello", AnnotatedHello.class);

        assertThat(hello, is(notNullValue()));

        AnnotatedHelloConfig config = ctx.getBean("annotatedHelloConfig", AnnotatedHelloConfig.class);
        assertThat(config, is(notNullValue()));

        assertThat(config.annotatedHello(), is(sameInstance(hello)));
    }
}