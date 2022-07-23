package jpa.domain;

import jpa.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // 카테고리 엔티티
@Getter @Setter
public class Category {
    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    /** @ManyToMany: 실무에선 일대다, 다대일 매핑으로 풀어서 사용 */
    @ManyToMany //상품 엔티티와 다대다 양방향 연관관계
    @JoinTable(name = "category_item", //연관관계의 주인
            joinColumns = @JoinColumn(name = "category_id"),  // 현재 방향인 카테고리 엔티티와 매핑할 조인 컬럼 정보 지정
            inverseJoinColumns = @JoinColumn(name = "item_id")) // 반대 방향인 상품 엔티티와 매핑할 조인 컬럼 정보 지정
    private List<Item> items = new ArrayList<>();

    /** @xxToOne: FetchType.LAZY 지연로딩 설정 */
    @ManyToOne(fetch = FetchType.LAZY) //자신의 필드인 child 와 다대일 양방향 연관관계
    @JoinColumn(name = "parent_id") //연관관계의 주인
    private Category parent;

    @OneToMany(mappedBy = "parent") //자신의 필드인 parent 와 일대다 양방향 연관관계, 연관관계의 주인이 아님
    private List<Category> child = new ArrayList<>();

    //==연관관계 메서드==//
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }
}
