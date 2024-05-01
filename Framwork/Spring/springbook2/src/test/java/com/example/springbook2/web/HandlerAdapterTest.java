package com.example.springbook2.web;

import com.example.springbook2.web.customControllerHandlerAdapter.HelloController;
import com.example.springbook2.web.customControllerHandlerAdapter.SimpleHandlerAdapter;
import org.junit.Test;

import javax.servlet.ServletException;
import java.io.IOException;

public class HandlerAdapterTest extends AbstractDispatcherServletTest {

    @Test
    public void simpleHandlerAdapter() throws ServletException, IOException {
        setClasses(SimpleHandlerAdapter.class, HelloController.class);
        initRequest("/hello").addParameter("name", "Spring").runService();

        assertViewName("/WEB-INF/views/hello.jsp");
        assertModel("message", "Hello Spring");
    }

}