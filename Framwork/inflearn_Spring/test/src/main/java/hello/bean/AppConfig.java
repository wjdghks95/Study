package hello.bean;

import hello.bean.discount.DiscountPolicy;
import hello.bean.discount.FixDiscountPolicy;
import hello.bean.discount.RateDiscountPolicy;
import hello.bean.member.MemberRepository;
import hello.bean.member.MemberService;
import hello.bean.member.MemberServiceImpl;
import hello.bean.member.MemoryMemberRepository;
import hello.bean.order.OrderService;
import hello.bean.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
