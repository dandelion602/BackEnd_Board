package com.dandelion.board.controller;


import com.dandelion.board.entity.Board;
import com.dandelion.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class BoardController {

    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/addBoard", method = RequestMethod.POST)
    public Board save(@RequestBody Board board) {
        return boardService.save(board);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Board> boardList() {
        return boardService.boardList();
    }

    @RequestMapping(value = "/findBoardId/{id}", method = RequestMethod.GET)
    public Optional<Board> findId(@PathVariable int id) {
        return boardService.findId(id);
    }

    @RequestMapping(value = "/modifyBoard/{id}", method = RequestMethod.POST)
    public Board modifyBoard(@PathVariable int id, @RequestBody Board newBoard) {
        return boardService.modifyBoard(id, newBoard);
    }

    @RequestMapping(value = "/imgView", method = RequestMethod.GET)
    public String path() {
        return "C:/Users/M/Desktop/projcet/BackEnd_Board/fileupload-spring/src/main/resources/static/images/x6FWJkr2IPlilFBhCun6YoFeNMEzf4Pv.jpg";

    }
}
