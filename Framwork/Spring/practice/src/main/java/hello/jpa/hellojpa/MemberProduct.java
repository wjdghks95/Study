package hello.jpa.hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 연결 테이블용 엔티티 추가
 * 다대다에서 일대다, 다대일 관계로
 */
@Entity
public class MemberProduct {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    private int count;
    private int price;
    private LocalDateTime orderDateTime;
}
