package hello.springcore.order;

import hello.springcore.annotation.MainDiscountPolicy;
import hello.springcore.discount.DiscountPolicy;
import hello.springcore.discount.FixDiscountPolicy;
import hello.springcore.discount.RateDiscountPolicy;
import hello.springcore.member.Member;
import hello.springcore.member.MemberRepository;
import hello.springcore.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * DIP(의존관계 역전 원칙) - 추상화에 의존
 * DI(의존관계 주입)
 */
@Component
//@RequiredArgsConstructor // 의존관계 자동 주입
public class OrderServiceImpl implements OrderService{

//    MemberRepository memberRepository = new MemoryMemberRepository();
//    DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 생성자 주입 방식(@Qualifier - 2개이상 조회된 빈의 의존관계 주입시 구분자로 지정)
/*
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
*/

    // 생성자 주입 방식(@MainDiscountPolicy - Custom Annotation)
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
