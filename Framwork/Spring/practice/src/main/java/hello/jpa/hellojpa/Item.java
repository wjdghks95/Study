package hello.jpa.hellojpa;

import javax.persistence.*;

/**
 * 상속관계 매핑
 * 전략
 *  - @Inheritance(strategy = InheritanceType.JOINED): 조인 전략 매핑
 *  - @Inheritance(strategy = InheritanceType.SINGLE_TABLE): 단일 테이블 전략
 *  - @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS): 구현 클래스마다 테이블 생성 전략
 *
 * @DiscriminatorColumn: 저장된 자식 테이블 구분
 * @DiscriminatorValue("Value"): 엔티티를 저장할 때 구분 컬럼에 입력할 값을 지정
 */
@Entity
// 부모 클래스에 구분 컬럼을 지정하기 위해 을 사용해
// Album의 경우 엔티티를 저장할 때 DTYPE에 값 A가 저장되고, Movie는 값 M이 저장
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID") // PK
    private Long id;

    private String name; // 이름
    private int price; // 가격
}
