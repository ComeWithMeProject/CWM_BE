package com.cwm.develop.board.controller;

import com.cwm.develop.board.dto.BoardRequestDto;
import com.cwm.develop.board.dto.BoardResponseDto;
import com.cwm.develop.board.dto.SuccessResponseDto;
import com.cwm.develop.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    //전체 목록 조회
    @GetMapping("/posts")
    public List<BoardResponseDto> getPosts() {
        return boardService.getPosts();
    }

    //페이징 처리한 목록 조회
    @GetMapping("/paging/posts")
    public Page<BoardResponseDto> getPostsPage(@RequestParam(required = false, defaultValue = "0", value = "page") int pageNo,
                                               @RequestParam(required = false, defaultValue = "createdAt", value = "orderBy") String criteria,
                                               @RequestParam(required = false, defaultValue = "DESC", value = "sort") String sort) {
        return boardService.getPostsPage(pageNo, criteria, sort);
    }

    //게시글 작성
    @PostMapping("/post")
    public BoardResponseDto createPost(@RequestBody BoardRequestDto requestDto) {
        return boardService.createPost(requestDto);
    }

    //선택한 게시글 조회
    @GetMapping("/post/{id}")
    public BoardResponseDto getPost(@PathVariable Long id) {
        return boardService.getPost(id);
    }

    //선택한 게시글 수정
    @PutMapping("/post/{id}")
    public BoardResponseDto updatePost(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) throws Exception {
        return boardService.updatePost(id, requestDto);
    }

    //게시글 삭제
    @DeleteMapping("/post/{id}")
    public SuccessResponseDto deletePost(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) throws Exception{
        return boardService.deletePost(id, requestDto);
    }

    //게시글 검색(아직 미완성)
    @GetMapping("/post/search")
    public Page<BoardResponseDto> searchPost(@RequestParam(required = true, value = "writer") String writer,
                                             @RequestParam int pageNo) {
        return boardService.searchByWriter(writer, pageNo);
    }
}
