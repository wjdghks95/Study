package jpa.domain;

import jpa.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity //주문 상품 엔티티
@Table(name = "order_item")
@Getter @Setter
public class OrderItem {
    @Id @GeneratedValue
    @Column(name = "order_item_id") private Long id;

    /** @xxToOne: FetchType.LAZY 지연로딩 설정 */
    @ManyToOne(fetch = FetchType.LAZY) //상품 엔티티와 다대일 양방향 연관관계
    @JoinColumn(name = "item_id") //연관관계의 주인
    private Item item; //상품

    @ManyToOne(fetch = FetchType.LAZY) //주문 엔티티와 다대일 양방향 연관관계
    @JoinColumn(name = "order_id") //연관관계의 주인
    private Order order; //주문

    private int orderPrice; //주문 가격

    private int count; //주문 수량

    //==생성 메서드==//
    public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);
        item.removeStock(count);
        return orderItem;
    }

    //==비즈니스 로직==//
    /** 주문 취소 */
    public void cancel() {
        getItem().addStock(count);
    }

    //==조회 로직==//
    /** 주문상품 전체 가격 조회 */
    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }
}
