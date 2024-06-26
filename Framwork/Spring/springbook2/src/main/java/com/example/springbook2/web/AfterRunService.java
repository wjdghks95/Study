package com.example.springbook2.web;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;

public interface AfterRunService {
    String getContentAsString() throws UnsupportedEncodingException;
    WebApplicationContext getContext();
    <T> T getBean(Class<T> beanType);
    ModelAndView getModelAndView();
    AfterRunService assertViewName(String viewname);
    AfterRunService assertModel(String name, Object value);
}
