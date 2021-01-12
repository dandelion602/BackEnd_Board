package com.dandelion.board.service;

import com.dandelion.board.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;

@Service
public class ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    BoardService boardService;


}
