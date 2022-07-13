package hello.mvc.servlet.web.springmvc.v1;

import hello.mvc.servlet.domain.member.Member;
import hello.mvc.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Controller: 스프링이 자동으로 스프링 빈 등록
 * @RequestMapping: 요청 정보를 매핑
 *  - 핸들러 매핑으로 핸들러 조회: RequestMappingHandlerMapping 실행
 *  - 핸들러 어댑터 조회: RequestMappingHandlerAdapter 실행
 * ModelAndView: 모델과 뷰 정보를 담아서 반환
 */
@Controller
public class SpringMemberSaveControllerV1 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members/save")
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        Member member = new Member(username, age);
        System.out.println("member = " + member);

        memberRepository.save(member);

        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member", member);
        return mv;
    }
}
