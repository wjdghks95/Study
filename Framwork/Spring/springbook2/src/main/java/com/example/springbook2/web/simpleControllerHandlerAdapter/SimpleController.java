package com.example.springbook2.web.simpleControllerHandlerAdapter;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public abstract class SimpleController implements Controller {

    private String[] requiredParams; // 필수 파라미터를 정의한다. 이 파라미터만 control() 메소드로 전달된다.
    private String viewName;

    public void setRequiredParams(String[] requiredParams) {
        this.requiredParams = requiredParams;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    @Override
    final public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        if (viewName == null) throw new IllegalStateException(); // 뷰 이름 프로퍼티가 지정되지 않았으면 예외를 발생시킨다.

        Map<String, String> params = new HashMap<>();
        for (String param : requiredParams) {
            // 필요한 파라미터를 가져와 맵에 담는다. 존재하지 않으면 예외를 던진다.
            String value = httpServletRequest.getParameter(param);
            if (value == null) throw new IllegalStateException();
            params.put(param, value);
        }

        Map<String, Object> model = new HashMap<>(); // 모델용 맵 오브젝트를 미리 만들어서 전달해준다.

        this.control(params, model); // 개별 컨트롤러가 구현할 메소드를 호출해준다.

        return new ModelAndView(this.viewName, model); // Controller 인터페이스 정의에 따라 ModelAndView 타입의 결과를 돌려준다.
    }

    public abstract void control(Map<String, String> params, Map<String, Object> model) throws Exception; // 서브클래스가 구현할 실제 컨트롤러 로직을 담을 메소드다.
}
