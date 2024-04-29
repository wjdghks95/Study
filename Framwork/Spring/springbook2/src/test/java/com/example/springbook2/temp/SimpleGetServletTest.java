package com.example.springbook2.temp;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class SimpleGetServletTest {

    @Test
    public void mvcTest() throws ServletException, IOException {
        MockHttpServletRequest req = new MockHttpServletRequest("GET", "/hello");
        req.addParameter("name", "Spring");

        MockHttpServletResponse res = new MockHttpServletResponse();

        SimpleGetServlet servlet = new SimpleGetServlet();
        servlet.service(req, res);

        assertThat(res.getContentAsString(), is("<HTML><BODY>Hello Spring</BODY></HTML>"));
    }

}