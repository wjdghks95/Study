package com.example.springbook2.web.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.view.xml.MarshallingView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class HelloController implements Controller {

    @Resource
    MarshallingView helloMarshallingView;

    @Autowired
    HelloPdfView helloPdfView;

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        // 모델 생성
        Map<String, Object> model = new HashMap<>();
        model.put("message", "Hello Spring");

        ModelAndView mav;

        // 뷰 생성
        // InternalResourceView
        InternalResourceView view = new InternalResourceView("/WEB-INF/views/hello.jsp");
        mav = new ModelAndView(view, model);
        mav = new ModelAndView("/WEB-INF/views/hello.jsp", model);

        // RedirectView
        mav = new ModelAndView(new RedirectView("/main", true));
        mav = new ModelAndView("redirect:/main");

        // MarshallingView
        mav = new ModelAndView(helloMarshallingView, model);

        // AbstractPdfView
        mav = new ModelAndView(this.helloPdfView, model);

        return mav;
    }
}
