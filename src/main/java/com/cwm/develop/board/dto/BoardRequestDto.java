package com.cwm.develop.board.dto;

import lombok.Getter;

//@Setter
//@NoArgsConstructor
@Getter
public class BoardRequestDto {

    private String title; //제목
    private String writer; //작성자
    private String content; //내용
    private String password; //비밀번호
    //private User user;

}
