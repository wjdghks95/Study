package jpa.domain;

import lombok.Getter;
import javax.persistence.Embeddable;

@Embeddable //임베디드 타입
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    //기본 생성자 필수
    protected Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
