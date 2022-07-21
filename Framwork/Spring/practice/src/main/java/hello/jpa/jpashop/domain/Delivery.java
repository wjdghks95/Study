package hello.jpa.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity // 배송 엔티티
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery") // 일대일 양방향 관계, 연관관계 주인이 아님
    private Order order;

    @Embedded // 추가
    private Address address; // 추가

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}
