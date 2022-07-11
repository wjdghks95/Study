package jpabook.jpashop2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberRepository0 {

    private final EntityManager em;

    public Long save(Member0 member) {
        em.persist(member);
        return member.getId();
    }

    public Member0 find(Long id) {
        return em.find(Member0.class, id);
    }
}
