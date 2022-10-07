package wjdghks95.project.rol.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

    private String nickname;

    private String address;

    private String phone;

    private String profileImage;

    private String role;

    private LocalDateTime createdAt;

    @Builder
    public Member(String email, String password, String name, String nickname, String address, String phone, String profileImage, String role, LocalDateTime createdAt) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.address = address;
        this.phone = phone;
        this.profileImage = profileImage;
        this.role = role;
        this.createdAt = createdAt;
    }
}
