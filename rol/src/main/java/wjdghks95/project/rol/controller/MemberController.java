package wjdghks95.project.rol.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import wjdghks95.project.rol.domain.dto.MemberDto;
import wjdghks95.project.rol.domain.entity.Member;
import wjdghks95.project.rol.service.MemberService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "loginForm";
    }

    @GetMapping("/signUp")
    public String signUpForm(Model model) {
        model.addAttribute("memberDto", new MemberDto());
        return "signUpForm";
    }

    @PostMapping("/signUp")
    public String signUp(@Validated @ModelAttribute MemberDto memberDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "signUpForm";
        }

        Member member = Member.builder()
                .email(memberDto.getEmail())
                .password(passwordEncoder.encode(memberDto.getPassword()))
                .phone(memberDto.getPhone())
                .name(memberDto.getName())
                .nickname(memberDto.getName())
                .address(memberDto.getAddress())
                .role("USER")
                .build();

        memberService.join(member);

        return "redirect:/";
    }
}
