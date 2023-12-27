package com.cwm.develop.board.repository;

import com.cwm.develop.board.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    //수정일시 기준 내림차순으로 전체 목록 조회
    List<Board> findAllByOrderByModifiedAtDesc();

    //페이징 처리를 통한 전체 목록 조회
    Page<Board> findAll(Pageable pageable);

    //페이징 처리 + 게시글 검색 기능
    Page<Board> findByWriterContaining(String writer, Pageable pageable);

}
