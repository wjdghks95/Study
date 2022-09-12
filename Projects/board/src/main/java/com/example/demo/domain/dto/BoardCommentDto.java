package com.example.demo.domain.dto;

import com.example.demo.domain.entity.BoardComment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardCommentDto {

    private String content;

    private String createBy;

    private Character delete_check;

    @Builder
    public BoardCommentDto(String content, String createBy, Character delete_check) {
        this.content = content;
        this.createBy = createBy;
        this.delete_check = delete_check;
    }

    public BoardComment toEntity() {
        return BoardComment.builder()
                .content(content)
                .createBy(createBy)
                .delete_check(delete_check)
                .build();
    }
}
