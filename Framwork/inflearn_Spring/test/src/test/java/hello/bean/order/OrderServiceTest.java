package hello.bean.order;

import hello.bean.AppConfig;
import hello.bean.member.Grade;
import hello.bean.member.Member;
import hello.bean.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "member", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "item", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}