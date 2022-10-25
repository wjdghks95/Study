package wjdghks95.project.rol.service;

import wjdghks95.project.rol.domain.dto.ReviewDto;
import wjdghks95.project.rol.domain.entity.Member;
import wjdghks95.project.rol.domain.entity.Review;

import java.io.IOException;

public interface ReviewService {
    public Long write(ReviewDto reviewDto, Member member) throws IOException;

    public Review findReview(Long id);
}
