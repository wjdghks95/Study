package hello.jpa.hellojpa.cascade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * cascade: 영속성 전이
 * cascadeType
 *  - ALL: 모두 적용
 *  - PERSIST: 영속
 *  - REMOVE: 삭제
 *  - MERGE: 병합
 *  - REFRESH: REFRESH
 *  - DETACH: DETACH
 *
 *  고아객체
 *  orphanRemoval = true: 부모 엔티티와 연관관계가 끊어진 자식 엔티티 자동 삭제
 *  참조하는 곳이 하나일 때 사용
 *  @OneToOne, @OneToMany 에서만 사용 가능
 */
// 영속성 전이를 활성화한 부모 엔티티
@Entity
@Getter @Setter
public class Parent {

    @Id @GeneratedValue
    private Long id;

    // 부모를 영속화할 때 자식들도 함께 영속화하라고 옵션 설정
    @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Child> children = new ArrayList<Child>();
}