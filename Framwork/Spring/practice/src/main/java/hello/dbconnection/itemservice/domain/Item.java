package hello.dbconnection.itemservice.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * ORM 매핑
 * @Entity: Jpa 가 사용하는 객체
 * @Id: 테이블의 PK와 해당 필드를 매핑
 * @GeneratedValue(strategy = GenerationType.IDENTITY): PK 생성 값을 데이터베이스에서 생성하는 IDENTITY 방식을 사용
 * @Column: 객체의 필드를 테이블의 컬럼과 매핑
 *
 * 기본 생성자 필수
 */
@Data
@Entity
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name", length = 10)
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
