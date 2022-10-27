package wjdghks95.project.rol.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wjdghks95.project.rol.domain.dto.ReviewDto;
import wjdghks95.project.rol.domain.entity.*;
import wjdghks95.project.rol.repository.LikeEntityRepository;
import wjdghks95.project.rol.repository.ReviewRepository;
import wjdghks95.project.rol.repository.ReviewTagRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final CategoryService categoryService;
    private final TagService tagService;
    private final ReviewTagRepository reviewTagRepository;
    private final ImageService imageService;
    private final LikeEntityRepository likeEntityRepository;

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

        review.setThumbnail(images);
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

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id).orElseThrow();
    }

    @Override
    public void like(Member member, Review review) {
        Optional<LikeEntity> byMemberAndReview = likeEntityRepository.findByMemberAndReview(member, review);

        byMemberAndReview.ifPresentOrElse(
                // 좋아요가 있을 경우 삭제
                reviewLike -> {
                    likeEntityRepository.delete(reviewLike);
                    review.discountLike(reviewLike);
                },

                // 좋아요가 없을 경우 좋아요 추가
                () -> {
                    LikeEntity likeEntity = LikeEntity.builder()
                                    .review(review)
                                    .member(member)
                                    .build();

                    likeEntity.setReview(review);
                    likeEntity.setMember(member);
                    review.updateLikeCount();

                    likeEntityRepository.save(likeEntity);
                }
        );
    }

    @Override
    public boolean isLike(Member member, Review review) {
        return likeEntityRepository.findByMemberAndReview(member, review).isEmpty();
    }


}
