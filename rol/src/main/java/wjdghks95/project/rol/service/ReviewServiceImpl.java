package wjdghks95.project.rol.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wjdghks95.project.rol.domain.dto.ReviewDto;
import wjdghks95.project.rol.repository.ReviewRepository;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;

    @Override
    public void write(ReviewDto reviewDto) {

    }
}
