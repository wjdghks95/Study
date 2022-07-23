package jpa.web;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;

/** 회원 등록 폼 입력 객체 */
@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수 입니다")
    private String name;

    private String city;

    private String street;

    private String zipcode;
}
