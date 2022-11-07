package wjdghks95.project.rol.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wjdghks95.project.rol.domain.entity.Category;
import wjdghks95.project.rol.domain.entity.CategoryName;
import wjdghks95.project.rol.domain.entity.Review;
import wjdghks95.project.rol.repository.CategoryRepository;
import wjdghks95.project.rol.repository.ReviewRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ContentsController {

    private final CategoryRepository categoryRepository;
    private final ReviewRepository reviewRepository;

    @GetMapping("/contents")
    public String contents(@RequestParam(value = "category", required = false) String categoryVal, Model model) {
        List<Review> reviewList = reviewRepository.findAll();
        model.addAttribute("reviewList", reviewList);

        if (categoryVal == null) {
            return "/contents/contents";
        }

        if (!categoryVal.equals("all")) {
            Category category = categoryRepository.findByCategoryName(CategoryName.valueOf(categoryVal.toUpperCase())).orElseThrow();
            reviewList = category.getReviewList();
            model.addAttribute("reviewList", reviewList);
        }
        return "/contents/category-content";
    }
}
