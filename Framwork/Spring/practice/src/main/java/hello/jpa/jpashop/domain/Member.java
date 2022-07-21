package hello.jpa.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity // 회원 엔티티
@Getter @Setter
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name; // 이름

    @OneToMany(mappedBy = "member") // 회원과 주문은 일대다 양방향 관계
    private List<Order> orders = new ArrayList<Order>();

    @Embedded
    private Address address;

    //Getter, Setter

}
