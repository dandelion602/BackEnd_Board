package com.dandelion.board.controller;

import com.dandelion.board.entity.Board;
import com.dandelion.board.service.BoardService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

@SpringBootTest
class BoardControllerTest {

    @Autowired
    BoardService boardService;

    @Test
    void searchWithTitle() throws Exception{
        Board board = new Board();
        board.setTitle("this is title");
        board.setContents("this is content");
        board.setPrice(2323);
        boardService.save(board);

        String part = "is";
        List<Board> searchedBoard = boardService.searchWithTitle(part);
        Assertions.assertThat(board.getTitle().contains(part)).isEqualTo(true);

    }
}