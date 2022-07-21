package hello.jpa.hellojpa;

import javax.persistence.*;

@Entity
public class Locker {

    @Id @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker") // 일대일 양방향 관계, 연관관계 주인이 아님
    private Member member;

/*
    @OneToOne // 일대일 양방향 관계, 연관관계 주인, 대상 테이블에 외래 키
    @JoinColumn (name = "MEMBER_ID")
    private Member member;
*/

}
