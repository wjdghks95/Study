package jpa.service;

import jpa.domain.Member;
import jpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // 읽기 전용 트랜잭션
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /** 회원가입 */
    @Transactional //변경 가능 트랜잭션
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /** 전체 회원 조회 */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /** 단일 회원 조회 */
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
