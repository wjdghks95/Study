package jpa.web;

import lombok.Getter;
import lombok.Setter;

/** Book 등록 폼 입력 객체 */
@Getter @Setter
public class BookForm {

    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    private String author;

    private String isbn;
}