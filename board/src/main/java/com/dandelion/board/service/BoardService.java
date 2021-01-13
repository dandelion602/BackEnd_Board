package com.dandelion.board.service;

import com.dandelion.board.entity.Board;
import com.dandelion.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public Board save(Board board) {
        return boardRepository.save(board);
    }

    public List<Board> boardList() {
        return boardRepository.findAll();
    }

    public Optional<Board> findId(int id) {
        return boardRepository.findById(id);
    }

    public Board findBoard(int number) {
        return boardRepository.getOne(number);
    }

    public Board modifyBoard(int id, Board newBoard) {
        Board board = boardRepository.getOne(id);
        board.setTitle(newBoard.getTitle());
        board.setContents(newBoard.getContents());
        board.setPrice(newBoard.getPrice());
        board.setModify_day(newBoard.getModify_day());
        return boardRepository.save(board);

    }
}
