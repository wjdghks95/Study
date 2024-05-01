package com.example.springbook2.web.customControllerHandlerAdapter;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class SimpleHandlerAdapter implements HandlerAdapter {

    // 이 핸들러 어댑터가 지원하는 타입을 확인해준다. 하나 이상의 타입을 지원하게 할 수도 있다.
    @Override
    public boolean supports(Object o) {
        return (o instanceof SimpleController);
    }

    @Override
    public ModelAndView handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Method m = ReflectionUtils.findMethod(o.getClass(), "control", Map.class, Map.class);

        // 컨트롤러 메소드의 애노테이션에서 필요한 정보를 가져온다. 스프링 유틸리티 클래스를 이용해 간단히 애노테이션을 가져올 수 있다.
        ViewName viewName = AnnotationUtils.getAnnotation(m, ViewName.class);
        RequiredParams requiredParams = AnnotationUtils.getAnnotation(m, RequiredParams.class);

        Map<String, String> params = new HashMap<>();
        for (String param : requiredParams.value()) { // 애노테이션 requiredParams의 value 엘리먼트 값을 사용한다.
            String value = httpServletRequest.getParameter(param);
            if (value == null) throw new IllegalStateException();
            params.put(param, value);
        }

        Map<String, Object> model = new HashMap<>();

        // DispatcherServlet은 컨트롤러의 타입을 모르기 때문에 컨트롤러를 Object 타입으로 넘겨준다.
        // 이를 적절한 컨트롤러의 타입으로 캐스팅해서 메소드를 호출해준다.
        ((SimpleController) o).control(params, model);

        return new ModelAndView(viewName.value(), model);
    }

    // getLastModified()는 컨트롤러의 getLastModified 메소드를 다시 호출해서 컨트롤러가 결정하도록 만든다.
    // 캐싱을 적용하지 않으려면 0보다 작은 값을 리턴한다.
    @Override
    public long getLastModified(HttpServletRequest httpServletRequest, Object o) {
        return -1;
    }
}
