package hello.jpa.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity // 회원 엔티티
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name; // 이름

    @OneToMany(mappedBy = "member") // 회원과 주문은 일대다 양방향 관계
    private List<Order> orders = new ArrayList<Order>();

    private String city; // 주소 CITY, STREET, ZIPCODE
    private String street;
    private String zipcode;

    //Getter, Setter

}
