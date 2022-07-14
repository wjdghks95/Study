package hello.login.web.Interceptor;

import hello.login.web.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * HandlerInterceptor 인터페이스 구현
 *  - preHandle: 컨트롤러 호출 전에 호출, preHandle 의 응답값이 true 이면 다음으로 진행하고 false 이면 더는 진행하지 않음
 *  - postHandle: 컨트롤러 호출 후에 호출
 *  - afterCompletion: 뷰가 렌더링 된 이후에 호출
 */
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        log.info("인증 체크 인터셉터 실행 {}", requestURI);
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
            log.info("미인증 사용자 요청");

            //로그인으로 redirect
            response.sendRedirect("/login?redirectURL=" + requestURI);

            return false; // 미인증 사용자는 다음으로 진행하지 않고 끝!
        }

        return true;
    }
}
