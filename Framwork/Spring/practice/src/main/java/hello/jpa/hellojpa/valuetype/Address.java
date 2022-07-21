package hello.jpa.hellojpa.valuetype;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * 값 타입과 불변 객체
 * 불변 객체: 생성 시점 이후 절대 값을 변경할 수 없는 객체
 * 생성자로만 값을 설정하고 Setter를 만들지 않으면 됨
 */
@Embeddable
@Getter
public class Address {

    String street;
    String city;
    String state;

    @Embedded
    Zipcode zipcode; // 임베디드 타입 포함

    // 값 타입은 기본 생성자가 필수
    public Address() {
    }

    public Address(String street, String city, String state, Zipcode zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
}
