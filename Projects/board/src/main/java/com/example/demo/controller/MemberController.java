package com.example.demo.controller;

import com.example.demo.domain.dto.MemberDto;
import com.example.demo.domain.entity.Member;
import com.example.demo.service.MemberService;
import com.example.demo.validator.MemberValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final MemberValidator memberValidator;

    @InitBinder("memberDto")
    public void validator(WebDataBinder dataBinder) {
        dataBinder.addValidators(memberValidator);
    }

    @GetMapping("/sign-up")
    public String addForm(Model model) {
        model.addAttribute("memberDto", MemberDto.builder().build());
        return "member/memberAddForm";
    }

    @PostMapping("/sign-up")
    public String addMember(@Validated @ModelAttribute MemberDto memberDto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "member/memberAddForm";
        }

        Long joinMemberId = memberService.join(memberDto);
        Member savedMember = memberService.findMember(joinMemberId).orElseThrow();
        model.addAttribute("member", savedMember);
        return "member/memberSaved";
    }

    @GetMapping("/login")
    public String login() {
        return "member/memberLoginForm";
    }

    @GetMapping("/memberLoginResult")
    public String loginResult() {
        return "member/memberLoginResult";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }
}
