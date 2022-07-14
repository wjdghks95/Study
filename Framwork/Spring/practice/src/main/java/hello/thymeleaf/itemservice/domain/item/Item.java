package hello.thymeleaf.itemservice.domain.item;

import lombok.Data;

import java.util.List;

@Data
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    /**
     * Thymeleaf 를 이용한 checkbox
     */
    private Boolean open; //판매 여부


    /**
     * Thymeleaf 를 이용한 multi checkbox
     * th:for="${#ids.prev('regions')}" id 를 다르게 설정
     */
    private List<String> regions; //등록 지역

    /**
     * Thymeleaf 를 이용한 radio button
     * th:for="${#ids.prev('itemType')}" id 를 다르게 설정
     */
    private ItemType itemType; //상품 종류

    /**
     * Thymeleaf 를 이용한 select
     */
    private String deliveryCode; //배송 방식

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
