package com.example.springbook2.web;

import com.example.springbook2.temp.HelloController;
import com.example.springbook2.temp.HelloSpring;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ConfigurableDispatcherServletTest {

    @Test
    public void configurableDispatcherServletTest() throws ServletException, IOException {
        ConfigurableDispatcherServlet servlet = new ConfigurableDispatcherServlet();
//        servlet.setRelativeLocations(getClass(), "spring-servlet.xml");
        servlet.setLocations("classpath:/spring-servlet.xml");
        servlet.setClasses(HelloSpring.class);
        servlet.init(new MockServletConfig("spring"));

        MockHttpServletRequest req = new MockHttpServletRequest("GET", "/hello");
        req.addParameter("name", "Spring");

        MockHttpServletResponse res = new MockHttpServletResponse();

        servlet.service(req, res);

        ModelAndView mav = servlet.getModelAndView();
        assertThat(mav.getViewName(), is("/WEB-INF/views/hello.jsp"));
        assertThat((String) mav.getModel().get("message"), is("Hello Spring"));
    }

    @Test
    public void controllerTest() throws Exception {
        GenericXmlApplicationContext ac = new GenericXmlApplicationContext("classpath:/spring-servlet.xml");
        HelloController helloController = ac.getBean(HelloController.class);

        MockHttpServletRequest req = new MockHttpServletRequest("GET", "/hello");
        req.addParameter("name", "Spring");
        MockHttpServletResponse res = new MockHttpServletResponse();

        ModelAndView mav = helloController.handleRequest(req, res);
        assertThat(mav.getViewName(), is("/WEB-INF/views/hello.jsp"));
        assertThat((String) mav.getModel().get("message"), is("Hello Spring"));
    }

}