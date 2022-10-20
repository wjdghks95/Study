package wjdghks95.project.rol.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wjdghks95.project.rol.domain.dto.ReviewDto;
import wjdghks95.project.rol.domain.entity.Category;
import wjdghks95.project.rol.domain.entity.Image;
import wjdghks95.project.rol.domain.entity.Member;
import wjdghks95.project.rol.domain.entity.Review;
import wjdghks95.project.rol.repository.ReviewRepository;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final CategoryService categoryService;

    private final ImageService imageService;

    @Transactional
    @Override
    public Review write(ReviewDto reviewDto, Member member) throws IOException {
        List<Image> images = imageService.saveImages(reviewDto.getMultipartFiles());
        for (Image image : images) {
            log.info("image: {}", image);
        }

        Category category = categoryService.saveCategory(reviewDto.getCategoryName());

        Review review = Review.builder()
                .title(reviewDto.getTitle())
                .content(reviewDto.getContent())
                .member(member)
                .category(category)
                .build();

        images.stream().forEach(image -> review.setImage(image));

        return reviewRepository.save(review);
    }
}
