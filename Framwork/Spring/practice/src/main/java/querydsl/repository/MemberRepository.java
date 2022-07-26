package querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import querydsl.entity.Member;

import java.util.List;

/**
 * 스프링 데이터 JPA Repository
 * 사용자 정의 Repository 상속 (Search Method 사용 가능)
 */
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

    List<Member> findByUsername(String username);
}
