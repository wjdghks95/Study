package wjdghks95.project.rol.controller;

import lombok.RequiredArgsConstructor;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import wjdghks95.project.rol.domain.entity.LikeEntity;
import wjdghks95.project.rol.domain.entity.Member;
import wjdghks95.project.rol.domain.entity.Review;
import wjdghks95.project.rol.repository.MemberRepository;
import wjdghks95.project.rol.security.service.MemberContext;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/myPage")
@RequiredArgsConstructor
public class MyPageController {

    private final MemberRepository memberRepository;


    @GetMapping("/profile/{id}")
    public String profile(@PathVariable Long id, @AuthenticationPrincipal MemberContext memberContext, Model model) {
        Member member = memberRepository.findById(id).orElseThrow();

        if (member.getId() != memberContext.getMember().getId()) {
            return "redirect:/";
        }

        model.addAttribute("member", member);
        return "myPage/myPage_profile";
    }

    @GetMapping("/myReview/{id}")
    public String myReview(@PathVariable Long id, @AuthenticationPrincipal MemberContext memberContext, Model model) {
        Member member = memberRepository.findById(id).orElseThrow();

        if (member.getId() != memberContext.getMember().getId()) {
            return "redirect:/";
        }

        List<Review> reviewList = member.getReviewList();

        model.addAttribute("reviewList", reviewList);
        return "myPage/myPage_myReview";
    }

    @GetMapping("/like/{id}")
    public String myLike(@PathVariable Long id, @AuthenticationPrincipal MemberContext memberContext, Model model) {
        Member member = memberRepository.findById(id).orElseThrow();

        if (member.getId() != memberContext.getMember().getId()) {
            return "redirect:/";
        }

        List<LikeEntity> likeList = member.getLikeList();

        model.addAttribute("likeList", likeList);
        return "myPage/myPage_like";
    }
}
