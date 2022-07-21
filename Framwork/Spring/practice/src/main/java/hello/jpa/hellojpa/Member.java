package hello.jpa.hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 객체와 테이블 매핑
 * @Entity: @Entity 가 붙은 클래스는 JPA 가 관리
 * @Table: 엔티티와 매핑할 테이블 지정
 *
 * 필드와 컬럼 매핑
 * @Column: 컬럼 매핑
 * @Enumerated: enum 타입 매핑, EnumType.STRING: enum 이름을 데이터베이스에 저장
 * @Temporal: 날짜 타입 매핑, LocalDate, LocalDateTime 을 사용할 경우 생략 가능
 * @Lob: 데이터베이스 BLOB, CLOB 타입과 매핑
 * @Transient: 특정 필드를 컬럼에 매핑하지 않음(무시)
 *
 * 기본 키 매핑
 * @Id: 기본키 직접 할당
 * @GeneratedValue: 자동 생성
 *  - IDENTITY 전략: 기본 키 생성을 데이터베이스에 위임(em.persist() 시점에 즉시 INSERT SQL 실행하고 DB에서 식별자를 조회)
 *  - SEQUENCE 전략: 유일한 값을 순서대로 생성하는 특별한 데이터베이스 오브젝트
 *  - TABLE 전략: 키 생성 전용 테이블을 하나 만들어서 데이터베이스 시퀀스를 흉내내는 전략
 */
@Entity
@Getter @Setter
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;

    /**
     * @JoinColumn: 외래 키 매핑
     *
     * 양방향 매핑 (주인)
     *   - 외래 키가 있는 있는 곳을 주인으로 지정
     *   - 연관관계의 주인만이 외래 키를 관리(등록, 수정)
     *   - 주인은 mappedBy 속성 사용X
     *
     * 다양한 연관관계 매핑
     *  - 다대일: @ManyToOne
     *  - 일대다: @OneToMany
     *  - 일대일: @OneToOne
     *  - 다대다: @ManyToMany
     */
    @ManyToOne // 다대일 양방향 매핑, 연관관계 주인
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @OneToOne // 일대일 양방향 관계, 연관관계 주인, 주 테이블에 외래 키
    @JoinColumn (name = "LOCKER_ID")
    private Locker locker;

/*
    @OneToOne(mappedBy = "member") // 일대일 양방향 관계, 연관관계 주인이 아님
    private Locker locker;
*/

/*
    @ManyToMany // 다대다 양방향 매핑, 연관관계 주인
    @JoinTable(name = "MEMBER_PRODUCT", // 연결 테이블을 지정
            joinColumns = @JoinColumn(name = "MEMBER_ID"), // 현재 방향인 회원과 매핑할 조인 컬럼 정보 지정
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID")) // 반대 방향인 상품과 매핑할 조인 컬럼 정보 지정
    private List<Product> products = new ArrayList<>();
*/

    // 다대다에서 일대다, 다대일 관계로
    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();

    public Member(){
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

/*
    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate testLocalDate;

    private LocalDateTime testLocalDateTime;

    @Lob
    private String description;

    @Transient
    private int temp;
*/
}
