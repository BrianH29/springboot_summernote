package com.bh.summernote.controller;

import com.bh.summernote.domain.Board;
import com.bh.summernote.dto.BoardDto;
import com.bh.summernote.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public String main(BoardDto boardDto, Model model){
        model.addAttribute("boardDto", boardDto);
        return "index";
    }

    @PostMapping("/post")
    public String savePost(BoardDto boardDto, Model model){
        boardService.savePost(boardDto);
        return "redirect:/";
    }
}
