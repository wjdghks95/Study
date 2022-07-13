package hello.mvc.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 핸들러 매핑으로 핸들러 조회 -> BeanNameUrlHandlerMapping 실행
 * 핸들러 어댑터 조회 -> SimpleControllerHandlerAdapter 실행
 * ViewResolver 호출 -> InternalResourceViewResolver 실행
 */
@Component("/springmvc/old-controller")
public class OldController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        return new ModelAndView("new-form");
    }
}
