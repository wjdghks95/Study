package com.example.jwt.controller;

import com.example.jwt.auth.PrincipalDetails;
import com.example.jwt.model.Member;
import com.example.jwt.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class RestApiController {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("home")
    public String home() {
        return "<h1>home</h1>";
    }

    @PostMapping("/token")
    public String token() {
        return "<h1>token</h1>";
    }

    @PostMapping("/join")
    public String join(@RequestBody Member member) {
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        member.setRoles("ROLE_USER");
        memberRepository.save(member);
        return "회원가입완료";
    }

    // user, manager, admin 권한 접근 가능
    @GetMapping("user")
    public String user(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        System.out.println(principalDetails.getMember().getId());
        System.out.println(principalDetails.getMember().getUsername());
        System.out.println(principalDetails.getMember().getPassword());
        return "user";
    }

    // manager, admin 권한 접근 가능
    @GetMapping("manager")
    public String manager() {
        return "manager";
    }

    // admin 권한 접근 가능
    @GetMapping("admin")
    public String admin() {
        return "admin";
    }
}
