package wjdghks95.project.rol.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wjdghks95.project.rol.domain.dto.ReviewDto;
import wjdghks95.project.rol.domain.entity.*;
import wjdghks95.project.rol.repository.ReviewRepository;
import wjdghks95.project.rol.repository.ReviewTagRepository;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final CategoryService categoryService;
    private final TagService tagService;
    private final ReviewTagRepository reviewTagRepository;
    private final ImageService imageService;

    @Transactional
    @Override
    public Long write(ReviewDto reviewDto, Member member) throws IOException {
        List<Image> images = imageService.saveImages(reviewDto.getMultipartFiles());

        Category category = categoryService.saveCategory(reviewDto.getCategoryName());
        List<Tag> tagList = tagService.saveTag(reviewDto.getTagNames());

        Review review = Review.builder()
                .title(reviewDto.getTitle())
                .description(reviewDto.getDescription())
                .rating(reviewDto.getRating())
                .category(category)
                .build();

        review.setMember(member);
        images.stream().forEach(image -> review.setImage(image));

        Review savedReview = reviewRepository.save(review);

        tagList.forEach(tag -> {
            ReviewTag reviewTag = ReviewTag.builder()
                    .review(savedReview)
                    .tag(tag)
                    .build();

            reviewTagRepository.save(reviewTag);
        });

        return savedReview.getId();
    }
}
