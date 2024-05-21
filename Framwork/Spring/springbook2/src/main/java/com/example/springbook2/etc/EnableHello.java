package com.example.springbook2.etc;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//@Import(HelloConfig.class)
@Import(HelloSelector.class)
public @interface EnableHello {
//    String name();
    String mode();
}
