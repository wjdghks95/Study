package wjdghks95.project.rol.domain.entity;

import lombok.*;
import wjdghks95.project.rol.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

    private String nickname;

    private String zipcode;

    private String address;

    private String detailAddress;

    private String phone;

    private String profileImage;

    private String role;

//    private List<Follow> followList;
//    private List<Like> likeList;
//    private List<Review> reviewList;
//    private List<Comment> commentList;

    @Builder
    public Member(String email, String password, String name, String nickname, String zipcode, String address, String detailAddress, String phone, String profileImage, String role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.zipcode = zipcode;
        this.address = address;
        this.detailAddress = detailAddress;
        this.phone = phone;
        this.profileImage = profileImage;
        this.role = role;
    }
}