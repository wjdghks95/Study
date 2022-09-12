package com.example.demo.security.config;

import com.example.demo.security.provider.FormAuthenticationProvider;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MemberService memberService;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationProvider formAuthenticationProvider() {
        return new FormAuthenticationProvider();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/member/myInfo", "/board/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/**").permitAll()
        .and()
                .formLogin()
                .loginPage("/member/login")
                .defaultSuccessUrl("/member/memberLoginResult")
                .permitAll()
        .and()
                .logout()
                .logoutUrl("/member/logout")
                .deleteCookies("JSESSIONID", "remember-me")
                .invalidateHttpSession(true)
        .and()
                .exceptionHandling()
                .accessDeniedPage("/member/denied");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(formAuthenticationProvider());
//        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
    }
}
