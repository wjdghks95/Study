package hello.bean.discount;

import hello.bean.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
