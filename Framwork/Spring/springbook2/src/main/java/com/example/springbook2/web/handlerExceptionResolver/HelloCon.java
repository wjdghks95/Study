package com.example.springbook2.web.handlerExceptionResolver;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloCon {
    @RequestMapping("/hello")
    public void hello() {
        // DAO 작업 중 예외 발생 가능성이 있다.
    }

    // AnnotationMethodHandlerExceptionResolver
    @ExceptionHandler(DataAccessException.class)
    public ModelAndView dataAccessExceptionHandler(DataAccessException exception) {
        return new ModelAndView("dataexception").addObject("msg", exception.getMessage()); // msg 모델 오브젝트와 함께 dataexception 뷰로 전환한다.
    }
}
