package com.example.demo.domain.entity;

import com.example.demo.domain.BaseTimeEntity;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    private String title;

    private String content;

    private String createBy;

    private Long countVisit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "board")
    private List<BoardComment> boardCommentList = new ArrayList<>();


    @Builder
    public Board(String title, String content, String createBy) {
        this.title = title;
        this.content = content;
        this.createBy = createBy;
        this.countVisit = 0L;
    }

    public void setMember(Member member) {
        if (this.member != null) {
            member.getBoardList().remove(this);
        }
        this.member = member;
        member.getBoardList().add(this);
    }

    public void updateVisit() {
        this.countVisit += 1;
    }
}