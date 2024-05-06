package com.example.springbook2.mvc.binding.propertyEditor;

import com.example.springbook2.mvc.binding.Level;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

public class MyWebBindingInitializer implements WebBindingInitializer {
    @Override
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
        webDataBinder.registerCustomEditor(Level.class, new LevelPropertyEditor());
    }
}
