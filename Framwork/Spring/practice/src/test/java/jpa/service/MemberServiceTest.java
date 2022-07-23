package jpa.service;

import jpa.domain.Member;
import jpa.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        //Given
        Member member = new Member();
        member.setName("kim");

        //When
        Long saveId = memberService.join(member);
        System.out.println("saveId = " + saveId);

        //Then
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        //Given
        Member member1 = new Member();
        member1.setName("kim");
        Member member2 = new Member();
        member2.setName("kim");

        //When
        memberService.join(member1);

        //Then
        Assertions.assertThatThrownBy(() -> memberService.join(member2)) //예외 발생
                .isInstanceOf(IllegalStateException.class);
    }
}