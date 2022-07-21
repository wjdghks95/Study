package hello.jpa.hellojpa.valuetype;

import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * 값 타입과 불변 객체
 * 불변 객체: 생성 시점 이후 절대 값을 변경할 수 없는 객체
 * 생성자로만 값을 설정하고 Setter를 만들지 않으면 됨
 */
@Embeddable // 값 타입 정의
@Getter
public class Period {

    @Temporal(TemporalType.DATE)
    Date startDate;

    @Temporal(TemporalType.DATE)
    Date endDate;

    // 값 타입은 기본 생성자가 필수
    public Period() {
    }

    public Period(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
