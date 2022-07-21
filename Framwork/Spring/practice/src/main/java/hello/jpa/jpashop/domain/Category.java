package hello.jpa.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // 카테고리 엔티티
@Getter @Setter
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Long id;

    private String name;

    /*
        다대다 관계는 연결 테이블을 JPA가 알아서 처리해주므로 편리하지만,
        연결 테이블에 필드가 추가되면 더는 사용할 수 없으므로 연결 엔티티를 만들어서 일대다, 다대일 관계로 매핑하는 것을 권장
     */
    @ManyToMany // 다대다 양방향 관계, 연관관계의 주인
    @JoinTable(name = "CATEGORY_ITEM",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
    private List<Item> items = new ArrayList<Item>();

    // 카테고리의 계층 구조를 위한 필드들
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<Category>();

    // ==연관관계 메서드== //
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }

    public void addItem(Item item) {
        items.add(item);
    }
}
