package com.cwm.develop.board.service;

import com.cwm.develop.board.Board;
import com.cwm.develop.board.dto.BoardRequestDto;
import com.cwm.develop.board.dto.BoardResponseDto;
import com.cwm.develop.board.dto.SuccessResponseDto;
import com.cwm.develop.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;

    //전체 목록 조회
    @Transactional
    public List<BoardResponseDto> getPosts() {
        return boardRepository.findAllByOrderByModifiedAtDesc().stream().map(BoardResponseDto::new).toList();
    }

    //게시글 작성
    @Transactional
    public BoardResponseDto createPost(BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        boardRepository.save(board);
        return new BoardResponseDto(board);
    }

    //선택한 게시글 조회
    @Transactional
    public BoardResponseDto getPost(Long boardId) {
        return boardRepository.findById(boardId).map(BoardResponseDto::new).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
    }

    //선택한 게시글 수정
    @Transactional
    public BoardResponseDto updatePost(Long boardId, BoardRequestDto requestDto) throws Exception {
        Board board = boardRepository.findById(boardId).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
        if(!requestDto.getPassword().equals(board.getPassword()))
            throw new Exception("비밀번호가 일치하지 않습니다.");

        board.update(requestDto);
        return new BoardResponseDto(board);
    }

    //선택한 게시글 삭제
    @Transactional
    public SuccessResponseDto deletePost(Long boardId, BoardRequestDto requestDto) throws Exception {
        Board board = boardRepository.findById(boardId).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다."));

        if(!requestDto.getPassword().equals(board.getPassword()))
            throw new Exception("비밀번호가 일치하지 않습니다.");

        boardRepository.deleteById(boardId);
        return new SuccessResponseDto(true);
    }

    //페이징 처리해 게시글 조회
    @Transactional
    public Page<BoardResponseDto> getPostsPage(int pageNo, String criteria, String sort) {
        Pageable pageable = (sort.equals("ASC")) ?
                PageRequest.of(pageNo, 5, Sort.by(Sort.Direction.ASC, criteria))
                : PageRequest.of(pageNo, 5, Sort.by(Sort.Direction.DESC, criteria));

        return boardRepository.findAll(pageable).map(BoardResponseDto::new);
    }

    //페이징 처리해 게시글 검색기능
    @Transactional
    public Page<BoardResponseDto> searchByWriter(String writer, int pageNo) {
        if(writer.equals("")) writer = "";

        //, Sort.by("boardId").descending()
        PageRequest pageRequest = PageRequest.of(pageNo, 5);
        return boardRepository.findByWriterContaining(writer, pageRequest).map(BoardResponseDto::new);
    }
}
