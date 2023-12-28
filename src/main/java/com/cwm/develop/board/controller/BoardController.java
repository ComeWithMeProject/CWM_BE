package com.cwm.develop.board.controller;

import com.cwm.develop.board.Board;
import com.cwm.develop.board.dto.BoardRequestDto;
import com.cwm.develop.board.dto.BoardResponseDto;
import com.cwm.develop.board.dto.SuccessResponseDto;
import com.cwm.develop.board.service.BoardService;
import com.cwm.develop.global.common.MultiResponseDto;
import com.cwm.develop.translate.core.TranslateFn;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
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

    //페이징 처리한 전체 목록 조회
    @GetMapping("/paging/posts")
    public ResponseEntity getPostsPage(@RequestParam(required = false, defaultValue = "0", value = "page") int page,
                                       @RequestParam(required = false, defaultValue = "0", value = "size") int size,
                                       @RequestParam(required = false, defaultValue = "0", value = "original") int original,
                                       @RequestParam(required = false, defaultValue = "1", value = "translate") int translate) throws ParseException {
        Page<Board> result = boardService.getPostsPage(page -1, size);
        List<Board> lists = result.getContent();

        TranslateFn translateFn = new TranslateFn();
        for(int i=0; i<lists.size(); i++) {
            String translatesTitle = translateFn.translateFunction(lists.get(i).getTitle(), original, translate);
            String translatesContent = translateFn.translateFunction(lists.get(i).getContent(), original, translate);

            lists.get(i).setTitle(translatesTitle);
            lists.get(i).setContent(translatesContent);
        }

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
    public SuccessResponseDto deletePost(@PathVariable Long id) throws Exception{
        return boardService.deletePost(id);
    }

    //게시글 검색 + 페이징
    @GetMapping("/post/search")
    public ResponseEntity searchPosts(@RequestParam(value ="title",required = false) String title,
                                      @RequestParam @Positive int page,
                                      @RequestParam @Positive int size,
                                      @RequestParam(required = false, defaultValue = "0", value = "original") int original,
                                      @RequestParam(required = false, defaultValue = "1", value = "translate") int translate) throws ParseException {
        TranslateFn translateFn = new TranslateFn();
        String translateTitle = translateFn.translateFunction(title,original,translate);

        Page<Board> pageBoards = boardService.searchPosts(translateTitle, page, size);
        List<Board> lists = pageBoards.getContent();

        for(int i=0; i<lists.size(); i++) {
            String translatesTitle = translateFn.translateFunction(lists.get(i).getTitle(), translate, original);
            String translatesContent = translateFn.translateFunction(lists.get(i).getContent(), translate, original);

            lists.get(i).setTitle(translatesTitle);
            lists.get(i).setContent(translatesContent);
        }

        return new ResponseEntity(new MultiResponseDto<>(lists, pageBoards), HttpStatus.OK);
    }
}
