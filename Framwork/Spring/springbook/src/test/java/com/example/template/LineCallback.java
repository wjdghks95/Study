package com.example.template;

public interface LineCallback<T> {
    T doSomethingWithLine(String line, T value);
}
