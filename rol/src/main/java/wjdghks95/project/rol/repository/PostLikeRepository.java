package wjdghks95.project.rol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wjdghks95.project.rol.domain.entity.Member;
import wjdghks95.project.rol.domain.entity.PostLike;
import wjdghks95.project.rol.domain.entity.Review;

import java.util.Optional;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {

    Optional<PostLike> findByMemberAndReview(Member member, Review review);
}
