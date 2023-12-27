package com.cwm.develop.board.controller;

import com.cwm.develop.board.Board;
import com.cwm.develop.board.BoardMapper;
import com.cwm.develop.board.dto.BoardRequestDto;
import com.cwm.develop.board.dto.BoardResponseDto;
import com.cwm.develop.global.common.MultiResponseDto;
import com.cwm.develop.board.dto.SuccessResponseDto;
import com.cwm.develop.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    //private final BoardMapper mapper;
    private final BoardService boardService;

    //전체 목록 조회
    @GetMapping("/posts")
    public List<BoardResponseDto> getPosts() {
        return boardService.getPosts();
    }

    //페이징 처리한 전체 목록 조회
    @GetMapping("/paging/posts")
    public ResponseEntity getPostsPage(@RequestParam(required = false, defaultValue = "0", value = "page") int page,
                                       @RequestParam(required = false, defaultValue = "0", value = "size") int size) {
        Page<Board> result = boardService.getPostsPage(page -1, size);
        List<Board> lists = result.getContent();

        return new ResponseEntity(new MultiResponseDto<>(lists,result), HttpStatus.OK);
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
//    @GetMapping("/post/search")
//    public Page<BoardResponseDto> searchPost(@RequestParam(value = "writer") String writer,
//                                             @RequestParam int pageNo) {
////        System.out.println("writer : "+writer);
////        System.out.println("pageNo : "+pageNo);
//        return boardService.searchByWriter(writer, pageNo);
//    }
//    @GetMapping("/post/search")
//    public ResponseEntity searchWriter(@RequestParam(value ="writer",required = false) String writer,
//                                       @RequestParam @Positive int page,
//                                       @RequestParam @Positive int size) {
//
////        System.out.println("writer: "+writer);
////        System.out.println("page: "+page);
////        System.out.println("size: "+size);
//        Page<Board> pageBoards = boardService.searchByWriter(writer, page, size);
//        List<Board> boards = pageBoards.getContent();
//
//        return new ResponseEntity(new MultiResponseDto<>(mapper.boardToBoardResponseDto(boards), pageBoards),HttpStatus.OK);
//    }
}
