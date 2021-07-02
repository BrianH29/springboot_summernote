package com.bh.summernote.controller;

import com.bh.summernote.domain.Board;
import com.bh.summernote.dto.BoardDto;
import com.bh.summernote.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    //메인 페이지
    @GetMapping
    public String main(BoardDto boardDto, Model model){
        model.addAttribute("boardDto", boardDto);
        return "index";
    }

    //글 등록 하기
    @PostMapping("/post")
    public String savePost(BoardDto boardDto, Model model){
        model.addAttribute("boardDto", boardDto);
        boardService.savePost(boardDto);
        return "saved";
    }

    //메뉴바 list 클릭시
    @GetMapping("/list")
    public String boardList(Model model){
        List<BoardDto> list = boardService.getBoardList();
        model.addAttribute("boardList", list);
        return "list";
    }

    //글쓰기 버튼 클릭시
    @GetMapping("/write")
    public String write(BoardDto boardDto, Model model){
        model.addAttribute("boardDto", boardDto);
        return "index";
    }

    @DeleteMapping("/delete/{no}")
    public String deletePost(@PathVariable("no") Long id){
        boardService.deletePost(id);
        return "index";
    }
}
