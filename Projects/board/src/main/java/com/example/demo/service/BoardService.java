package com.example.demo.service;

import com.example.demo.domain.dto.BoardDto;
import com.example.demo.domain.entity.Board;
import com.example.demo.domain.entity.Member;
import com.example.demo.repository.BoardQueryRepository;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    private final BoardQueryRepository boardQueryRepository;

    @Transactional
    public Long saveBoard(BoardDto boardDto) {
        Member member = memberRepository.findByUsername(boardDto.getCreateBy()).orElseThrow();
        Board board = boardDto.toEntity();
        board.setMember(member);
        return boardRepository.save(board).getId();
    }

    public Page<Board> getBoardList(String searchText, Pageable pageable) {
        return boardQueryRepository.findSearchConditionBoard(searchText, pageable);
    }

    @Transactional
    public void updateVisit(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("해당 게시글이 존재하지 않습니다."));

        board.updateVisit();
    }
}
