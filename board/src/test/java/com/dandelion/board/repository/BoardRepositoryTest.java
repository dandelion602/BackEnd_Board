package com.dandelion.board.repository;

import com.dandelion.board.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    void save() {
        boardRepository.save(Board.builder()
                .CONTENTS("hello")
                .MEMBER_NUMBER(1)
                .DATE("2021-01-04")
                .MODIFY_DAY(null)
                .PRICE(20000)
                .TEMP_STATUS(1)
                .TITLE("팝니다")
                .VIEW(0)
                .build()
        );
    }
}