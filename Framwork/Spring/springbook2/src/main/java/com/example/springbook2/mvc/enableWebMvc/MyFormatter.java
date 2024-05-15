package com.example.springbook2.mvc.enableWebMvc;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class MyFormatter implements Formatter<String> {

    @Override
    public String parse(String s, Locale locale) throws ParseException {
        return null;
    }

    @Override
    public String print(String s, Locale locale) {
        return null;
    }
}
