package jpa.domain.item;

import jpa.domain.Category;
import jpa.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity //상품 엔티티
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //싱글 테이블 전략으로 상속
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Item {
    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    /** @ManyToMany: 실무에선 일대다, 다대일 매핑으로 풀어서 사용 */
    @ManyToMany(mappedBy = "items") //카테고리 엔티티와 다대다 연관관계, 연관관계의 주인이 아님
    private List<Category> categories = new ArrayList<Category>();

    //==비즈니스 로직==//

    /** 재고 증가 */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    /**
     * 재고 감소
     * 재고 부족시 예외 발생
     */
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock"); // 런타임 예외
        }
        this.stockQuantity = restStock;
    }
}
