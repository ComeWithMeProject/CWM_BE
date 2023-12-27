package com.cwm.develop.board.dto;

import com.cwm.develop.board.Board;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class BoardResponseDto {

    private Long boardId;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime createdAt; //생성일
    private LocalDateTime modifiedAt; //수정일
    //private User user;

    public BoardResponseDto(Board entity) {
        this.boardId = entity.getBoardId();
        this.writer = entity.getWriter();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createdAt = entity.getCreatedAt();
        this.modifiedAt = entity.getModifiedAt();
    }
}
