package wjdghks95.project.rol.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wjdghks95.project.rol.domain.dto.ReviewDto;
import wjdghks95.project.rol.domain.entity.Member;
import wjdghks95.project.rol.domain.entity.Review;
import wjdghks95.project.rol.repository.MemberRepository;
import wjdghks95.project.rol.security.service.MemberContext;
import wjdghks95.project.rol.service.ReviewService;

import java.io.IOException;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/review")
@RequiredArgsConstructor
@Slf4j
public class ReviewController {

    private final ReviewService reviewService;
    private final MemberRepository memberRepository;

    @GetMapping("/new")
    public String reviewForm(Model model) {
        model.addAttribute("reviewDto", new ReviewDto());
        return "review/reviewForm";
    }

    @PostMapping("/new")
    public String newReview(@ModelAttribute ReviewDto reviewDto, BindingResult bindingResult, @AuthenticationPrincipal MemberContext memberContext) throws IOException {
        if (bindingResult.hasErrors()) {
            log.info("bindingResult: {}", bindingResult.getFieldError());
            return "/review/reviewForm";
        }

        Long memberId = memberContext.getMember().getId();
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new NoSuchElementException("NoSuchElementException"));
        reviewService.write(reviewDto, member);

        return "redirect:/";
    }
}
