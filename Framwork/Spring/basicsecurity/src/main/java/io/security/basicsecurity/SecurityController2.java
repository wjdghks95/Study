package io.security.basicsecurity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * SecurityContextHolder, SecurityContext
 */
//@RestController
public class SecurityController2 {

    @GetMapping("/")
    public String index(HttpSession session) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // SecurityContext 에서 Authentication 조회

        // Session 에서 SecurityContext 를 찾고 Authentication 조회
        SecurityContext context = (SecurityContext) session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
        Authentication authentication1 = context.getAuthentication();

        return "home";
    }

    @GetMapping("/thread")
    public String thread() {

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        // MODE_THREADLOCAL 전략은 SecurityContext 가 공유되지 않음 -> MODE_INHERITABLETHREADLOCAL 사용
                        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // 새로운 Thread 에서 Authentication 조회
                    }
                }
        ).start();
        return "thread";
    }
}
