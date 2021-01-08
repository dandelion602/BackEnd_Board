package com.dandelion.board.controller;


import com.dandelion.board.entity.Board;
import com.dandelion.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BoardController {

    @Autowired
    BoardRepository boardRepository;

    @RequestMapping(value = "/addBoard", method = RequestMethod.POST)
    public Board addBoard(@RequestBody Board board) {
        return boardRepository.save(board);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Board> boardList() throws Exception {
        List<Board> boardList = boardRepository.findAll();
        return boardList;
    }

    @RequestMapping(value = "/findBoardId/{id}", method = RequestMethod.GET)
    public Optional<Board> findId(@PathVariable int id) {
        Optional<Board> findid = boardRepository.findById(id);
        return findid;
    }

    @RequestMapping(value = "/modifyBoard/{id}", method = RequestMethod.POST)
    public Board modifyBoard(@PathVariable int id, @RequestBody Board newBoard) {
        Board board = boardRepository.getOne(id);
        board.setTitle(newBoard.getTitle());
        board.setContents(newBoard.getContents());
        board.setPrice(newBoard.getPrice());
        board.setModify_day(newBoard.getModify_day());
        return boardRepository.save(board);
    }
}
