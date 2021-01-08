package com.dandelion.board.repository;

import com.dandelion.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    List<Board> findBytitle(String title);
}
