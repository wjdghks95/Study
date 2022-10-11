package wjdghks95.project.rol.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import wjdghks95.project.rol.domain.dto.MemberDto;
import wjdghks95.project.rol.domain.entity.Member;
import wjdghks95.project.rol.service.MemberService;
import wjdghks95.project.rol.validator.MemberDuplicateValidator;
import wjdghks95.project.rol.validator.SignUpValidator;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    private final PasswordEncoder passwordEncoder;

    private final MemberDuplicateValidator memberDuplicateValidator;

    private final SignUpValidator signUpValidator;

    @InitBinder("memberDto")
    public void memberDuplicateValidation(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
        dataBinder.addValidators(memberDuplicateValidator);
        dataBinder.addValidators(signUpValidator);
    }

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
                .zipcode(memberDto.getZipcode())
                .address(memberDto.getAddress())
                .detailAddress(memberDto.getDetailAddress())
                .role("USER")
                .build();

        memberService.join(member);

        return "redirect:/";
    }
}
