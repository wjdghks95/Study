package com.cos.security1.controller;

import com.cos.security1.model.Account;
import com.cos.security1.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired AccountRepository accountRepository;
    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/user")
    public String user() {
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
