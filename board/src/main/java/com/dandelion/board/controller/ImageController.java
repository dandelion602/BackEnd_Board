package com.dandelion.board.controller;

import com.dandelion.board.service.BoardService;
import com.dandelion.board.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    @Autowired
    BoardService boardService;

    @Autowired
    ImageService imageService;

    @GetMapping()

}
