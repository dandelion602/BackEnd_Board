package com.dandelion.board.service;

import com.dandelion.board.entity.Board;
import com.dandelion.board.entity.Image;
import com.dandelion.board.repository.BoardRepository;
import com.dandelion.board.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    ImageRepository imageRepository;

    public Board save(Board board) {
        return boardRepository.save(board);
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public Board findLastBoard() {
        return boardRepository.findLastBoard();
    }

    public List<Board> searchWithTitle(String title) {
        return boardRepository.searchWithTitle(title);
    }

    public Optional<Board> findById(int number) {
        return boardRepository.findById(number);
    }

    public Board getOne(int number) {
        return boardRepository.getOne(number);
    }

    public Board modifyBoard(int id, Board newBoard) {
        Board board = boardRepository.getOne(id);
        board.setTitle(newBoard.getTitle());
        board.setContents(newBoard.getContents());
        board.setPrice(newBoard.getPrice());
        board.setModifyDate(newBoard.getModifyDate());
        return boardRepository.save(board);

    }
}
