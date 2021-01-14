package com.dandelion.board;

import com.dandelion.board.entity.Board;
import com.dandelion.board.service.BoardService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardApplicationTests {

    @Autowired
    BoardService service;

    @Test
    void save() {

        Board board = new Board();
        board.setTitle("this is title");
        board.setPrice(121212);
        board.setContents("this is contents");


        service.save(board);

        int number = board.getNumber();
        System.out.println(number);
        Assertions.assertThat(service.findBoard(number)).isEqualTo(board);

    }

}
