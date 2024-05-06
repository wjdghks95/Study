package com.example.springbook2.mvc.binding.converterAndFormatter;

import com.example.springbook2.mvc.binding.Level;
import org.springframework.core.convert.converter.Converter;

public class LevelToStringConverter implements Converter<Level, String> {

    @Override
    public String convert(Level level) {
        return String.valueOf(level.intValue());
    }
}
