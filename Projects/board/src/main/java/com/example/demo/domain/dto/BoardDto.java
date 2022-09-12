package com.example.demo.domain.dto;

import com.example.demo.domain.entity.Board;
import com.example.demo.domain.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardDto {

    private String title;

    private String content;

    private String createBy;


    @Builder
    public BoardDto(String title, String content, String createBy) {
        this.title = title;
        this.content = content;
        this.createBy = createBy;
    }

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .createBy(createBy)
                .build();
    }
}

