package com.example.demo.controller;

import com.example.demo.domain.entity.Member;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final MemberService memberService;

    @GetMapping("/memberList")
    public String findAllMember(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "admin/memberList";
    }
}
