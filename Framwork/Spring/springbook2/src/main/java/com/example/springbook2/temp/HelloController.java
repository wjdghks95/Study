package com.example.springbook2.temp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class HelloController implements Controller {

    @Autowired
    HelloSpring helloSpring; // 부모 컨텍스트인 루트 컨텍스트로부터 HelloSpring 빈을 DI 받을 수 있다.

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String name = httpServletRequest.getParameter("name"); // 1. 사용자 요청 해석
        String message = this.helloSpring.sayHello(name); // 2. 비즈니스 로직 호출

        Map<String, Object> model = new HashMap<>();
        model.put("message", message); // 3. 모델 정보 생성

        return new ModelAndView("/WEB-INF/views/hello.jsp", model); // 4. 뷰 지정
    }
}
