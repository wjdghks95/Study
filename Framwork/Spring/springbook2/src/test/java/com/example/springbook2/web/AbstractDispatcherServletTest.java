package com.example.springbook2.web;

import org.junit.After;
import org.junit.runner.Request;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AbstractDispatcherServletTest implements AfterRunService {
    // 서블릿 목 오브젝트는 서브클래스에서 직접 접근 가능하다.
    protected MockHttpServletRequest request;
    protected MockHttpServletResponse response;
    protected MockServletConfig config = new MockServletConfig("spring");
    protected MockHttpSession session;

    // 서블릿 컨텍스트 생성을 위한 설정 메타정보는 클래스(classes), 클래스패스(locations), 상대 클래스패스(relativeLocations) 세 가지로 지정할 수 있다.
    private ConfigurableDispatcherServlet dispatcherServlet;
    private Class<?>[] classes;
    private String[] locations;
    private String[] relativeLocations;
    private String servletPath;

    public AbstractDispatcherServletTest setLocations(String ...locations) {
        this.locations = locations;
        return this;
    }

    public AbstractDispatcherServletTest setRelativeLocations(String ...relativeLocations) {
        this.relativeLocations = relativeLocations;
        return this;
    }

    public AbstractDispatcherServletTest setClasses(Class<?> ...classes) {
        this.classes = classes;
        return this;
    }

    public AbstractDispatcherServletTest setServletPath(String servletPath) {
        if (this.request == null)
            this.servletPath = servletPath;
        else
            this.request.setServletPath(servletPath);
        return this;
    }

    public AbstractDispatcherServletTest initRequest(String requestUri, String method) {
        this.request = new MockHttpServletRequest(method, requestUri);
        this.response = new MockHttpServletResponse();
        if (this.servletPath != null) this.setServletPath(this.servletPath);
        return this;
    }

    public AbstractDispatcherServletTest initRequest(String requestUri, RequestMethod method) {
        return this.initRequest(requestUri, method.toString());
    }

    public AbstractDispatcherServletTest initRequest(String requestUri) {
        this.initRequest(requestUri, RequestMethod.GET);
        return this;
    }

    public AbstractDispatcherServletTest addParameter(String name, String value) {
        if (this.request == null)
            throw new IllegalStateException("request가 초기화되지 않았습니다.");
        this.request.addParameter(name, value);
        return this;
    }

    public AbstractDispatcherServletTest buildDispatcherServlet() throws ServletException {
        if (this.classes == null && this.locations == null && this.relativeLocations == null)
            throw new IllegalStateException("classes와 locations 중 하나는 설정해야 합니다.");
        this.dispatcherServlet = new ConfigurableDispatcherServlet();
        this.dispatcherServlet.setClasses(this.classes);
        this.dispatcherServlet.setLocations(this.locations);
        if (this.relativeLocations != null)
            this.dispatcherServlet.setRelativeLocations(getClass(), this.relativeLocations);
        this.dispatcherServlet.init(this.config);

        return this;
    }

    public AfterRunService runService() throws ServletException, IOException {
        if (this.dispatcherServlet == null) buildDispatcherServlet();
        if (this.request == null)
            throw new IllegalStateException("request가 준비되지 않았습니다.");
        this.dispatcherServlet.service(this.request, this.response);
        return this;
    }

    public AfterRunService runService(String requestUri) throws ServletException, IOException {
        initRequest(requestUri);
        runService();
        return this;
    }


    @Override
    public WebApplicationContext getContext() {
        if (this.dispatcherServlet == null)
            throw new IllegalStateException("DispatcherServlet이 준비되지 않았습니다.");
        return this.dispatcherServlet.getWebApplicationContext();
    }

    @Override
    public <T> T getBean(Class<T> beanType) {
        if (this.dispatcherServlet == null)
            throw new IllegalStateException("DispatcherServlet이 준비되지 않았습니다.");
        return this.getContext().getBean(beanType);
    }

    @Override
    public ModelAndView getModelAndView() {
        return this.dispatcherServlet.getModelAndView();
    }

    @Override
    public AfterRunService assertModel(String name, Object value) {
        assertThat(this.getModelAndView().getModel().get(name), is(value));
        return this;
    }

    @Override
    public AfterRunService assertViewName(String viewname) {
        assertThat(this.getModelAndView().getViewName(), is(viewname));
        return this;
    }

    @Override
    public String getContentAsString() throws UnsupportedEncodingException {
        return this.response.getContentAsString();
    }

    @After
    public void closeServletContext() {
        if (this.dispatcherServlet != null) {
            ((ConfigurableApplicationContext) dispatcherServlet.getWebApplicationContext()).close();
        }
    }
}
