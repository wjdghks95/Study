package wjdghks95.project.rol.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class MemberDto {

    private String email;

    private String password;

    private String name;

    private String nickname;

    private String address;

    private String phone;

    @Builder
    public MemberDto(String email, String password, String name, String nickname, String address, String phone) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.address = address;
        this.phone = phone;
    }
}
