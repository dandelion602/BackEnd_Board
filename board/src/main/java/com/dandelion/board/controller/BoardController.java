package com.dandelion.board.controller;


import com.dandelion.board.entity.Board;
import com.dandelion.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardController {

    @Autowired
    BoardRepository boardRepository;

    @PostMapping("/addBoard")
    public Board addBoard(@RequestBody Board board) {
        return boardRepository.save(board);
    }
}
