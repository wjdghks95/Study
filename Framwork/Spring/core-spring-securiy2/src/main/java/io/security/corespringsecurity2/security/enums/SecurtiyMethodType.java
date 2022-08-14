package io.security.corespringsecurity2.security.enums;

public enum SecurtiyMethodType {

    METHOD("method"),
    POINTCUT("pointcut");

    private String name;

    SecurtiyMethodType(String name) {
        this.name = name;
    }

    public String getValue() {
        return name;
    }
}