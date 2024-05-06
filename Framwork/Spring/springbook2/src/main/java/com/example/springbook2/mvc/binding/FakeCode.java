package com.example.springbook2.mvc.binding;

public class FakeCode extends Code{
    @Override
    public String getName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setName(String name) {
        throw new UnsupportedOperationException();
    }
}
