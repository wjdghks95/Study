package hello.jpa.hellojpa.valuetype;

import hello.jpa.hellojpa.PhoneServiceProvider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * 값 타입과 불변 객체
 * 불변 객체: 생성 시점 이후 절대 값을 변경할 수 없는 객체
 * 생성자로만 값을 설정하고 Setter를 만들지 않으면 됨
 */
@Embeddable
@Getter
public class PhoneNumber {
    String areaCode;
    String localNumber;

    @ManyToOne
    PhoneServiceProvider provider; // 엔티티 참조

    public PhoneNumber() {
    }

    public PhoneNumber(String areaCode, String localNumber, PhoneServiceProvider provider) {
        this.areaCode = areaCode;
        this.localNumber = localNumber;
        this.provider = provider;
    }
}
