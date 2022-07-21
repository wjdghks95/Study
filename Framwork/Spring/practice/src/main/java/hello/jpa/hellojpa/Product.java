package hello.jpa.hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_ID")
    private Long id;

/*
    @ManyToMany(mappedBy = "products") // 다대다 양방향 매핑, 연관관계 주인이 아님
    private List<Member> members = new ArrayList<>();
*/

    // 다대다에서 일대다, 다대일 관계로
    @OneToMany(mappedBy = "product")
    private List<MemberProduct> memberProducts = new ArrayList<>();
}
