package com.example.ioccontaineranddi;

import javax.annotation.PostConstruct;

public class Hello2 {

    @PostConstruct
    public void init() {
        System.out.println("Init");
    }

    public String sayHello() {
        return "Hello ";
    }
}
