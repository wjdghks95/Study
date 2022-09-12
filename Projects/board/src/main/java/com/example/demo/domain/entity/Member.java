package com.example.demo.domain.entity;

import com.example.demo.domain.BaseTimeEntity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseTimeEntity implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String username;

    private String password;

    private String email;

    @OneToMany(mappedBy = "member")
    private List<Board> boardList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<BoardComment> boardCommentList = new ArrayList<>();

    @Builder
    public Member(String username, String password, String email, List<Board> boardList) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.boardList = boardList;
    }

    public Member update(String username) {
        this.username = username;
        return this;
    }
}
