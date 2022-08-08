package io.security.corespringsecurity.security.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 사용자 정의 AuthenticationSuccessHandler
 *  - 인증 성공 후 후처리를 원하는대로 정의하여 로직 수행
 */
@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RequestCache requestCache = new HttpSessionRequestCache(); // 이전에 요청했던 요청 저장 객체
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy(); // Redirect 전략

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        setDefaultTargetUrl("/"); // default 이동 URL 페이지 설정

        SavedRequest savedRequest = requestCache.getRequest(request, response); // 이전 요청
        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl(); // 이전 요청 Url
            redirectStrategy.sendRedirect(request, response, targetUrl); // 이전 요청 Url로 Redirect
        } else {
            redirectStrategy.sendRedirect(request, response, getDefaultTargetUrl()); // Default Url로 Redirect
        }
    }
}
