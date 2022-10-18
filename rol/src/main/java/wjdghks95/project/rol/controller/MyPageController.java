package wjdghks95.project.rol.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import wjdghks95.project.rol.domain.entity.Member;
import wjdghks95.project.rol.repository.MemberRepository;
import wjdghks95.project.rol.security.service.MemberContext;

@Controller
@RequestMapping("/myPage")
@RequiredArgsConstructor
public class MyPageController {

    private final MemberRepository memberRepository;

    @GetMapping("/profile/{id}")
    public String profile(@PathVariable Long id, @AuthenticationPrincipal MemberContext memberContext, Model model) {
        Member member = memberRepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException();
        });
        model.addAttribute("member", member);
        return "mypage/myPage_profile";
    }
}
