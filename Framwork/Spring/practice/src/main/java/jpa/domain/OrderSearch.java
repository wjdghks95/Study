package jpa.domain;

import lombok.Getter;
import lombok.Setter;

//검색 조건 객체
@Getter @Setter
public class OrderSearch {

    private String memberName; //회원 이름

    private OrderStatus orderStatus;//주문 상태[ORDER, CANCEL]
}
