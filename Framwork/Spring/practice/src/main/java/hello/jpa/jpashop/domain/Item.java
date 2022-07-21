package hello.jpa.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // 상품 엔티티
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 상속 - 싱글 테이블 전략
@DiscriminatorColumn(name = "DTYPE")
@Getter @Setter
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;        // 이름
    private int price;          // 가격
    private int stockQuantity;  // 재고수량

    @ManyToMany(mappedBy = "items") // 다대다 양방향 관계, 연관관계의 주인이 아님
    private List<Category> categories = new ArrayList<Category>();


    //Getter, Setter

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                '}';
    }
}
