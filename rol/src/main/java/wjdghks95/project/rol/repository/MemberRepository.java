package wjdghks95.project.rol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wjdghks95.project.rol.domain.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
