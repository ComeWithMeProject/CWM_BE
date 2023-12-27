package com.cwm.develop.board;

import com.cwm.develop.board.dto.BoardRequestDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "BOARD")
@AllArgsConstructor
public class Board extends BaseTimeEntity{

    //게시판ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boardId")
    private Long boardId;

    //작성자
    @Column(length = 15, nullable = false)
    private String writer;

    //제목
    @Column(columnDefinition = "NVARCHAR(30) NOT NULL")
    private String title;

    //내용
    @Column(columnDefinition = "TEXT NOT NULL")
    private String content;

    //비밀번호
    @Column(nullable = false)
    private String password;

//    @ManyToOne
//    @JoinColumn(name = "userId")
//    private User user;

    public Board(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.writer = requestDto.getWriter();
        this.password = requestDto.getPassword();
    }

    public void update(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.writer = requestDto.getWriter();
        this.password = requestDto.getPassword();
    }

}
