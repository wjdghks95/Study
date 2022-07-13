package hello.mvc.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller: 스프링이 자동으로 스프링 빈 등록
 * @RequestMapping: 요청 정보를 매핑
 *  - 핸들러 매핑으로 핸들러 조회: RequestMappingHandlerMapping 실행
 *  - 핸들러 어댑터 조회: RequestMappingHandlerAdapter 실행
 * ModelAndView: 모델과 뷰 정보를 담아서 반환
 */
@Controller
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}
