package hello.jpa.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity // 주문상품 엔티티
@Table(name = "ORDER_ITEM")
@Getter @Setter
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // 주문상품과 상품은 다대일 단방향 관계, 연관관계의 주인
    @JoinColumn(name = "ITEM_ID")
    private Item item; // 주문 상품

    @ManyToOne(fetch = FetchType.LAZY) // 주문상품과 주문은 다대일 양방향 관계, 연관관계의 주인
    @JoinColumn(name = "ORDER_ID")
    private Order order; // 주문

    private int orderPrice; // 주문 금액
    private int count; // 주문 수량

    //Getter, Setter


    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", orderPrice=" + orderPrice +
                ", count=" + count +
                '}';
    }
}
