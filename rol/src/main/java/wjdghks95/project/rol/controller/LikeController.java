package wjdghks95.project.rol.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import wjdghks95.project.rol.domain.entity.Member;
import wjdghks95.project.rol.domain.entity.Review;
import wjdghks95.project.rol.repository.MemberRepository;
import wjdghks95.project.rol.security.service.MemberContext;
import wjdghks95.project.rol.service.ReviewService;

@RestController
@RequiredArgsConstructor
public class LikeController {

    private final ReviewService reviewService;

    private final MemberRepository memberRepository;

    @GetMapping("/review/{id}/like")
    public int like(@PathVariable Long id, @AuthenticationPrincipal MemberContext memberContext) {
        Member member = memberRepository.findById(memberContext.getMember().getId()).orElseThrow();
        Review review = reviewService.findById(id);

        reviewService.like(member, review);
        int likeCount = review.getLikeCount();
        return likeCount;
    }
}
