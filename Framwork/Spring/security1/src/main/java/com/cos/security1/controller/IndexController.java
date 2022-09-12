package com.cos.security1.controller;

import com.cos.security1.config.auth.PrincipalDetails;
import com.cos.security1.model.Account;
import com.cos.security1.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired AccountRepository accountRepository;
    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/test/login")
    @ResponseBody
    public String testLogin(Authentication authentication, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        System.out.println("/test/login===============");
        PrincipalDetails principalDetails2 = (PrincipalDetails) authentication.getPrincipal();
        System.out.println("authentication: " + principalDetails2.getAccount());
        System.out.println("userDetails: " + principalDetails.getAccount());
        return "세션 정보 확인하기";
    }

    @GetMapping("/test/oauth/login")
    @ResponseBody
    public String testOAuthLogin(Authentication authentication, @AuthenticationPrincipal OAuth2User oAuth2User) {
        System.out.println("/test/oauth/login===============");
        OAuth2User oAuth2User2 = (OAuth2User) authentication.getPrincipal();
        System.out.println("authentication: " + oAuth2User2.getAttributes());
        System.out.println("authentication: " + oAuth2User.getAttributes());
        return "OAuth 세션 정보 확인하기";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/user")
    @ResponseBody
    public String user(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        System.out.println("principalDetails: " + principalDetails.getAccount());
        return "user";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/manager")
    public String manager() {
        return "manager";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @PostMapping("/joinForm")
    public String join(@ModelAttribute Account account) {
        System.out.println(account);
        account.setRole("ROLE_USER");
        String rawPassword = account.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        account.setPassword(encPassword);
        accountRepository.save(account);
        return "redirect:/loginForm";
    }

    @GetMapping("/joinProc")
    @ResponseBody
    public String joinProc() {
        return "회원가입 완료됨!";
    }


    @GetMapping("/info")
    @Secured("ROLE_ADMIN")
    @ResponseBody
    public String info() {
        return "개인정보";
    }

    @GetMapping("/data")
    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER') or hasAnyAuthority('ROLE_ADMIN')")
    @ResponseBody
    public String data() {
        return "데이터정보";
    }
}
