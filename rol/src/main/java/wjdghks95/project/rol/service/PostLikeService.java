package wjdghks95.project.rol.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wjdghks95.project.rol.domain.entity.Member;
import wjdghks95.project.rol.domain.entity.PostLike;
import wjdghks95.project.rol.domain.entity.Review;
import wjdghks95.project.rol.repository.PostLikeRepository;
import wjdghks95.project.rol.repository.ReviewRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostLikeService {

    private final PostLikeRepository postLikeRepository;
    private final ReviewRepository reviewRepository;

    public PostLike findPostLike(Member member, Review review) {

        //중복 좋아요 방지
        return postLikeRepository.findByMemberAndReview(member, review).orElseGet(() ->
                postLikeRepository.save(PostLike.builder()
                        .member(member)
                        .review(review)
                        .build())
        );
    }

}
