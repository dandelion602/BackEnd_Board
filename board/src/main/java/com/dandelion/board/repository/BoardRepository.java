package com.dandelion.board.repository;

import com.dandelion.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BoardRepository extends JpaRepository<Board, Integer> {

    @Query(value = "SELECT * FROM board ORDER BY number DESC LIMIT 1;", nativeQuery = true)
    Board findLastBoard();

    @Query(value = "select * from board where title like '%part%'", nativeQuery = true)
    List<Board> searchWithTitle(@Param("part") String part);

}