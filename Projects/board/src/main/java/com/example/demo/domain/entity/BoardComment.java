package com.example.demo.domain.entity;

import com.example.demo.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardComment extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String createBy;

    private Character delete_check;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public BoardComment(String content, String createBy, Character delete_check) {
        this.content = content;
        this.createBy = createBy;
        this.delete_check = delete_check;
    }

    public void setMember(Member member) {
        if (this.member != null) {
            member.getBoardCommentList().remove(this);
        }
        this.member = member;
        member.getBoardCommentList().add(this);
    }

    public void setBoard(Board board) {
        if (this.board != null) {
            board.getBoardCommentList().remove(this);
        }
        this.board = board;
        board.getBoardCommentList().add(this);
    }
}
