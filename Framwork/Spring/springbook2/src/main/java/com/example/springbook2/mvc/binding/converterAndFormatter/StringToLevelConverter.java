package com.example.springbook2.mvc.binding.converterAndFormatter;

import com.example.springbook2.mvc.binding.Level;
import org.springframework.core.convert.converter.Converter;

public class StringToLevelConverter implements Converter<String, Level> {
    @Override
    public Level convert(String s) {
        return Level.valueOf(Integer.parseInt(s));
    }
}
