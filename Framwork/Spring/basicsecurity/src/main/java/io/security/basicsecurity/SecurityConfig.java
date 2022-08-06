package io.security.basicsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * WebSecurityConfigurerAdapter: 스프링 시큐리티의 웹 보안 기능 초기화 및 설정
 *  -> 최신버전부터 SecurityFilterChain 타입의 빈을 생성하는 것으로 대체
 */
//@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    // AuthenticationManagerBuilder: 인증 객체를 만들 수 있는 API 제공
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("{noop}1111").roles("USER");
        auth.inMemoryAuthentication().withUser("sys").password("{noop}1111").roles("SYS", "USER");
        auth.inMemoryAuthentication().withUser("admin").password("{noop}1111").roles("ADMIN", "SYS", "USER");
    }

    // HttpSecurity: 세부적인 보안 기능을 설정할 수 있는 API 제공
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 인가 API
         */
        http
                .authorizeRequests() // 시큐리티 처리에 HttpServletRequest 를 이용
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/user").hasRole("USER") // .antMatchers: 특정 경로 지정
                .antMatchers("/admin/pay").hasRole("ADMIN")
                .antMatchers("/admin/**").access("hasRole('ADMIN') or hasRole('SYS')")
                .anyRequest().authenticated(); // .anyRequest(): antMatchers 경로를 제외한 모든 요청

        /**
         * 인증 API
         */
        http
                .formLogin() // UsernamePasswordAuthenticationFilter 동작
//                .loginPage("/loginPage") // 사용자 정의 로그인 페이지
                .defaultSuccessUrl("/") // 로그인 성공 후 이동 페이지
                .failureUrl("/login") // 로그인 실패 후 이동 페이지
                .usernameParameter("userId") // 아이디 파라미터명 설정
                .passwordParameter("passwd") // 패스워드 파라미터명 설정
                .loginProcessingUrl("/login_proc") // 로그인 Form Action Url
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        System.out.println("authentication : " + authentication.getName());

                        // 해당 객체에 이전에 요청받은 url 정보를 세션에 저장하고 인증이 된다면 해당 url로 이동하게 설정
                        RequestCache requestCache = new HttpSessionRequestCache();
                        SavedRequest savedRequest = requestCache.getRequest(request, response);
                        String redirectUrl = savedRequest.getRedirectUrl();
                        response.sendRedirect(redirectUrl);
                    }
                })  // 로그인 성공 후 핸들러
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                        System.out.println("exception : " + exception.getMessage());
                        response.sendRedirect("/login");
                    }
                }) // 로그인 실패 후 핸들러
                .permitAll()
        ;

        http
                .logout() // 로그아웃 처리, LogoutFilter 동작
                .logoutUrl("/logout") // 로그아웃 처리 URL
                .logoutSuccessUrl("/login") // 로그아웃 성공 후 이동페이지
                .addLogoutHandler(new LogoutHandler() {
                    @Override
                    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
                        HttpSession session = request.getSession();
                        session.invalidate();
                    }
                }) // 로그아웃 핸들러
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.sendRedirect("/login");
                    }
                }) // 로그아웃 성공 후 핸들러
                .deleteCookies("remember-me") // 로그아웃 후 쿠키 삭제

                .and()

                .rememberMe() // RememberMe 기능 동작
                .rememberMeParameter("remember") // 기본 파라미터명은 remember-me
                .tokenValiditySeconds(3600) // 쿠키 만료 시간, Default 는 14일
                .alwaysRemember(false) // 리멤버 미 기능 활성화 여부
                .userDetailsService(userDetailsService) // remember me 기능을 수행할 때 시스템의 사용자 계정을 조회할 때 처리를 설정
        ;

        http
                .sessionManagement() // 세션 관리 기능 작동
                .sessionFixation().changeSessionId() // 세션 고정 보호, Default
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) // 세션 정책, 스프링 시큐리티가 필요 시 세션 생성, Default
                .maximumSessions(1) // 최대 허용 가능 세션 수 , -1 : 무제한 로그인 세션 허용
                .maxSessionsPreventsLogin(false) // ture: 동시 로그인 차단, false: 기존 세션 만료(default)
        ;

        /**
         * 예외 처리 API
         */
        http
                .exceptionHandling() // 예외처리 기능 작동
                .authenticationEntryPoint(new AuthenticationEntryPoint() {
                    @Override
                    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
                        response.sendRedirect("/login");
                    }
                })  // 인증 실패 시 처리
                .accessDeniedHandler(new AccessDeniedHandler() {
                    @Override
                    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
                        response.sendRedirect("/denied");
                    }
                }) // 인가 실패 시 처리
        ;

        /**
         * CsrfFilter
         */
//        http.csrf().disable(); // CsrfFilter 비활성화
    }
}
