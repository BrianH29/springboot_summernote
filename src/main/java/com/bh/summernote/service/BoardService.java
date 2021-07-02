package com.bh.summernote.service;

import com.bh.summernote.domain.Board;
import com.bh.summernote.dto.BoardDto;
import com.bh.summernote.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Long savePost(BoardDto boardDto) {
      return boardRepository.save(boardDto.toEntity()).getId();
    }
}
