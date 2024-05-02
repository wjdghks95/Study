package com.example.springbook2.web;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebContextLoader implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 루트 컨텍스트 등록
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
//        servletContext.scan("com.mycompany.myproject.config");

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("spring", new DispatcherServlet());
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/app/*");

        // 컨텍스트 로더 리스너 등록
        ContextLoaderListener listener = new ContextLoaderListener(ac);
        servletContext.addListener(listener);

        // 컨텍스트 파라미터 설정
//        servletContext.setInitParameter("contextClass", "org.springframework.web.context.support.AnnotationConfigWebApplicationContext");
//        servletContext.setInitParameter("contextConfigLocation", "myproject.config");

        AnnotationConfigWebApplicationContext sac = new AnnotationConfigWebApplicationContext();
//        sac.register(WebConfig.class);
        dispatcher = servletContext.addServlet("spring", new DispatcherServlet(sac));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/app");
    }
}
