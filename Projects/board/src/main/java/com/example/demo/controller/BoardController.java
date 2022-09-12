package com.example.demo.controller;

import com.example.demo.domain.dto.BoardCommentDto;
import com.example.demo.domain.dto.BoardDto;
import com.example.demo.domain.dto.PageDto;
import com.example.demo.domain.entity.Board;
import com.example.demo.domain.entity.BoardComment;
import com.example.demo.domain.entity.Member;
import com.example.demo.repository.BoardCommentRepository;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;
    private final BoardCommentRepository boardCommentRepository;
    private final MemberRepository memberRepository;

    @GetMapping("/add")
    public String addBoardForm() {
        return "board/boardForm";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute BoardDto boardDto) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Member member = (Member) principal;
        boardDto.setCreateBy(member.getUsername());
        boardService.saveBoard(boardDto);
        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public String list(@PageableDefault(size = 10) Pageable pageable, Model model,
                       @RequestParam(required = false, defaultValue = "") String searchText) {
        Page<Board> boards = boardService.getBoardList(searchText, pageable);

        model.addAttribute("boards", boards);
        model.addAttribute("page", new PageDto(boards.getTotalElements(), pageable));
        model.addAttribute("searchText", searchText);
        return "board/boardList";
    }

    @GetMapping("/boardContent/{id}")
    public String boardContent(@PathVariable Long id, Model model) {
        Board board = boardRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("해당 게시글이 존재하지않습니다.");
        });
        boardService.updateVisit(id);

        List<BoardComment> comments = boardCommentRepository.findBoardComments(id);

        model.addAttribute("boardCommentDto", BoardCommentDto.builder().build());
        model.addAttribute("board", board);
        model.addAttribute("comments", comments);
        return "board/boardContent";
    }

    @PostMapping("/boardContent/{id}")
    public String addComment(@PathVariable Long id, @Validated @ModelAttribute BoardCommentDto boardCommentDto, Model model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Member member = (Member) principal;

        Member savedMember = memberRepository.findByUsername(member.getUsername()).orElseThrow(() -> new IllegalStateException("해당 유저가 존재하지 않습니다."));
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalStateException("해당 게시글이 존재하지 않습니다."));

        boardCommentDto.setCreateBy(member.getUsername());
        boardCommentDto.setDelete_check('N');
        BoardComment boardComment = boardCommentDto.toEntity();

        boardComment.setMember(savedMember);
        boardComment.setBoard(board);
        boardCommentRepository.save(boardComment);

        List<BoardComment> comments = boardCommentRepository.findBoardComments(id);

        model.addAttribute("comments", comments);
        model.addAttribute(board);

        return "board/boardContent";
    }
}
