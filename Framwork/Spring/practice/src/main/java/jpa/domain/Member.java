package jpa.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity //회원 엔티티
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded //임베디드 타입
    private Address address;

    @OneToMany(mappedBy = "member") //주문 엔티티와 일대다 양방향 연관관계, 연관관계의 주인이 아님
    private List<Order> orders = new ArrayList<>();
}
