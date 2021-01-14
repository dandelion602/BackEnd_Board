package com.dandelion.board.service;

import com.dandelion.board.entity.Board;
import com.dandelion.board.repository.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class BoardServiceTest {

    @Autowired
    BoardService service;
    @Autowired
    BoardRepository boardRepository;

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
