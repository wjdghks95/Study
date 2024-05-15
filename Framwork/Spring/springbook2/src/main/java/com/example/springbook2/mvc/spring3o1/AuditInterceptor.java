package com.example.springbook2.mvc.spring3o1;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuditInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod hm = (HandlerMethod) handler;
        if (hm.getMethodAnnotation(Audit.class) != null) {
            saveAuditInfo(request, response, handler);
        }

        return super.preHandle(request, response, handler);
    }

    private void saveAuditInfo(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 요청정보를 감사 용도의 외부 파일에 저장하는 코드
    }
}
