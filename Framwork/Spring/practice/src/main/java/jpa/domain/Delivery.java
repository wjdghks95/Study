package jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity //배송정보 엔티티
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    /** @xxToOne: FetchType.LAZY 지연로딩 설정 */
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY) //주문 엔티티와 일대일 양방향 연관관계, 연관관계의 주인이 아님
    private Order order;

    @Embedded //임베디드 타입
    private Address address;

    @Enumerated(EnumType.STRING) //Enum 타입
    private DeliveryStatus status; //배송 상태 [READY(준비), COMP(배송)]
}