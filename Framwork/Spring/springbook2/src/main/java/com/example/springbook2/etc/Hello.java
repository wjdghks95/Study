package com.example.springbook2.etc;

public class Hello {
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello " + name);
    }
}
