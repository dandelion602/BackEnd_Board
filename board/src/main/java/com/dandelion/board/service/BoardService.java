package com.dandelion.board.service;

import com.dandelion.board.entity.Board;
import com.dandelion.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }
}
