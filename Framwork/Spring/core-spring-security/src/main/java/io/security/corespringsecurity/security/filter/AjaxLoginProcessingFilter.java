package io.security.corespringsecurity.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.security.corespringsecurity.domain.AccountDto;
import io.security.corespringsecurity.security.token.AjaxAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AjaxAuthenticationFilter: Ajax 인증 필터
 * AbstractAuthenticationProcessingFilter 상속 받아 구현
 */
public class AjaxLoginProcessingFilter extends AbstractAuthenticationProcessingFilter {

    // Json을 객체에 담기 위해 ObjectMapper를 사용
    private ObjectMapper objectMapper = new ObjectMapper();

    // 요청 정보와 매칭하여 요청 방식이 Ajax 인 경우 필터 작동
    public AjaxLoginProcessingFilter() {
        super(new AntPathRequestMatcher("/api/login"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        if (!isAjax(request)) {
            throw new IllegalStateException("Authentication is not supported");
        }

        AccountDto accountDto = objectMapper.readValue(request.getReader(), AccountDto.class);
        if (StringUtils.isEmpty(accountDto.getUsername()) || StringUtils.isEmpty(accountDto.getPassword())) {
            throw new IllegalStateException("Username or Password is empty");
        }

        // AjaxAuthenticationToken 을 생성하여 AuthenticationManager 에 전달
        AjaxAuthenticationToken authenticationToken = new AjaxAuthenticationToken(accountDto.getUsername(), accountDto.getPassword());
        return getAuthenticationManager().authenticate(authenticationToken);
    }

    // Ajax 인지 아닌지 기준을 두어 Ajax 일 경우 필터 작동
    private boolean isAjax(HttpServletRequest request) {

        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-with"))) {
            return true;
        }
        return false;
    }
}
