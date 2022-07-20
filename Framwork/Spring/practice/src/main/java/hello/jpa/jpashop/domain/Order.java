package hello.jpa.jpashop.domain;

import javax.persistence.*;
import java.util.Date;

@Entity // 주문 엔티티
@Table(name = "ORDERS")
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId; // 상품을 주문할 회원의 외래키 값

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate; // 주문 날짜

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // 주문 상태

    //Getter, Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
