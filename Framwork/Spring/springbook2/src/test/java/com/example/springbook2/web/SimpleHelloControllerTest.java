package com.example.springbook2.web;

import com.example.springbook2.temp.HelloSpring;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SimpleHelloControllerTest extends AbstractDispatcherServletTest {
    @Test
    public void helloController() throws ServletException, IOException {
//        ModelAndView mav =
                // 컨텍스트를 위한 설정파일과 빈 클래스 등록
//                .setRelativeLocations("spring-servlet.xml")
                setLocations("classpath:/spring-servlet.xml")
                .setClasses(HelloSpring.class)

                // 요청정보 설정과 파라미터 추가
                .initRequest("/hello", RequestMethod.GET)
                .addParameter("name", "Spring")

                // DispatcherServlet 실행
                .runService()

                // 검증
                .assertModel("message", "Hello Spring")
                .assertViewName("/WEB-INF/views/hello.jsp");

//                .getModelAndView();


//        assertThat(mav.getViewName(), is("/WEB-INF/views/hello.jsp"));
//        assertThat((String) mav.getModel().get("message"), is("Hello Spring"));
    }
}
